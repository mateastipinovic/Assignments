package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerForm;
import com.agency04.sbss.pizza.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private CustomerService customerService;

    @Autowired
    public CustomerRestController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {
        Customer customer = customerService.findByUsername(username);
        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        Customer tempCustomer = customerService.findByUsername(username);
        customerService.deleteByUsername(username);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/")
    public CustomerForm registerCustomer(@RequestBody CustomerForm customer) {
        customerService.save(customer);
        return  customer;
    }

    @PutMapping("/")
    public CustomerForm updateCustomer(@RequestBody CustomerForm customer) {
       Customer tempCustomer = customerService.findByUsername(customer.getUsername());
       if(tempCustomer == null) {
           throw new CustomerNotFoundException("Customer with username " + customer.getUsername() + " doesn't exist.");
       }
       customerService.save(customer);
       return customer;
    }
}