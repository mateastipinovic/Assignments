package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.DAO.*;
import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;

@Component
class DbInitializer implements ApplicationRunner {

    @Autowired
    private final CustomerRepository theCustomerRepository;
    private final CustomerDetailsRepository theCustomerDetailsRepository;
    private final DeliveryRepository theDeliveryRepository;
    private final PizzaRepository thePizzaRepository;
    private final PizzaOrderRepository thePizzaOrderRepository;

    public DbInitializer(CustomerRepository theCustomerRepository, CustomerDetailsRepository theCustomerDetailsRepository, DeliveryRepository theDeliveryRepository, PizzaRepository thePizzaRepository, PizzaOrderRepository thePizzaOrderRepository) {
        this.theCustomerRepository = theCustomerRepository;
        this.theCustomerDetailsRepository = theCustomerDetailsRepository;
        this.theDeliveryRepository = theDeliveryRepository;
        this.thePizzaRepository = thePizzaRepository;
        this.thePizzaOrderRepository = thePizzaOrderRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        CustomerDetails customerDetails1 =theCustomerDetailsRepository.save(new CustomerDetails(1, "Ivan", "Ivić", "0914152145"));
        CustomerDetails customerDetails2 =theCustomerDetailsRepository.save(new CustomerDetails(2, "Marko", "Matić", "0914154455"));

        theCustomerRepository.save(new Customer(1,"Ivan", customerDetails1));
        theCustomerRepository.save(new Customer(2,"Marko",customerDetails2));

        theDeliveryRepository.save(new Delivery(1, LocalDate.of(2021, 2,1)));
        theDeliveryRepository.save(new Delivery(2, LocalDate.of(2019, 12,27)));

        thePizzaRepository.save(new Pizza(1, "Carbonara", Arrays.asList(Ingredient.MOZZARELLA, Ingredient.BACON)));
        thePizzaRepository.save(new Pizza(2, "Marinara", Arrays.asList(Ingredient.MOZZARELLA, Ingredient.OREGANO)));

        thePizzaOrderRepository.save(new PizzaOrder(1,"5", Size.LARGE));
        thePizzaOrderRepository.save(new PizzaOrder(2,"3", Size.MEDIUM));

    }
}