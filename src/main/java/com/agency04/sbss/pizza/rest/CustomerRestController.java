package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private List<Customer> customers;

    @PostConstruct
    public void loadData() {
        customers = new ArrayList<>();
        customers.add(new Customer(0, "Ivan Ivić", "Ivićeva 32"));
        customers.add(new Customer(1, "Matko Matić", "Matićeva 55"));
        customers.add(new Customer(2, "Stipe Stipić", "Stipićeva 1"));
    }

    @GetMapping("/{username}")
    public Customer getCustomer(@PathVariable String username) {
        Customer customer = customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
        if(customer == null){
            throw new CustomerNotFoundException("Customer with username " + username + " doesn't exist.");
        }
        return customer;
    }

    @DeleteMapping("/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        Customer customer = customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
        if(customer == null){
            throw new CustomerNotFoundException("Customer with username " + username + " doesn't exist.");
        }
        customers.remove(customer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) {
        customers.add(new Customer(customer));
        if(customers.stream().filter(x -> x.getCustomerId() == customer.getCustomerId()).findFirst().orElse(null) == null ){
            throw new CustomerNotFoundException("Customer is not registered.");
        }
        return  ResponseEntity.ok(HttpStatus.CREATED).status(201).build();
    }

    @PutMapping("/")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        Customer temp = customers.stream().filter(x -> x.getCustomerId() == customer.getCustomerId()).findFirst().orElse(null);
        if (temp != null) {
            int index = customers.indexOf(temp);
            customers.set(index, customer);
            if(Objects.equals(customers.get(index), customer)){
                return  ResponseEntity.ok(HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}