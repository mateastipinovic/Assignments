package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.DAO.CustomerRepository;
import com.agency04.sbss.pizza.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerRestController(CustomerRepository theCustomerService){
        customerRepository= theCustomerService;
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {
        Customer customer = customerRepository.findByUsername(username);
        if(customer == null){
            throw new CustomerNotFoundException("Customer with username " + username + " doesn't exist.");
        }
        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        Customer tempCustomer = customerRepository.findByUsername(username);

        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer with username " + username + " doesn't exist.");
        }

        customerRepository.deleteByUsername(username);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) {
        customer.setId(0);
        customerRepository.save(customer);
        if(customerRepository.findByUsername(customer.getUsername()) == null ){
            throw new CustomerNotFoundException("Customer is not registered.");
        }
        return  ResponseEntity.ok(HttpStatus.CREATED).status(201).build();
    }

    @PutMapping("/")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        Optional<Customer> tempCustomer = customerRepository.findById(customer.getId());;
        if (tempCustomer.isPresent()) {
            customerRepository.save(tempCustomer.get());
            if(customer.equals(customerRepository.findById(customer.getId()))){
                return  ResponseEntity.ok(HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}