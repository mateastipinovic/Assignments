package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.DAO.CustomerRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.CustomerForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;
    private ConverterClass converter;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, ConverterClass converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    @Override
    public Customer findById(int id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            throw new RuntimeException("Did not find customer id - " + id);
        }
        return customer.get();
    }

    @Override
    public Customer findByUsername(String username) {
        Customer customer = customerRepository.findByUsername(username);

        if (customer == null) {
            throw new RuntimeException("Did not find customer username - " + username);
        }
        return customer;
    }

    @Override
    public void deleteByUsername(String username) {
        customerRepository.deleteByUsername(username);
    }

    @Override
    public void save(CustomerForm customerForm) {
        Customer customer = converter.customerToCustomerForm(customerForm);
        customerRepository.save(customer);
    }
}
