package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    private List<Customer> customers;

    @PostConstruct
    public void loadData() {
        customers = new ArrayList<>();
        customers.add(new Customer(0, "Ivan Ivić", "Ivićeva 32"));
        customers.add(new Customer(1, "Matko Matić", "Matićeva 55"));
        customers.add(new Customer(2, "Stipe Stipić", "Stipićeva 1"));
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username) {
        return customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        customers.remove(customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) {
        customers.add(new Customer(customer));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        Customer temp = customers.stream().filter(x -> x.getCustomerId() == customer.getCustomerId()).findFirst().orElse(null);
        if (temp != null) {
            int index = customers.indexOf(temp);
            customers.set(index, customer);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }
}