package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerForm;

public interface CustomerService {
    Customer findById(int id);
    Customer findByUsername(String username);
    void deleteByUsername(String username);
    void save(CustomerForm customer);
}
