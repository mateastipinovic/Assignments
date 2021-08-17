package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.DAO.*;
import com.agency04.sbss.pizza.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
        theCustomerRepository.save(new Customer(1,"Ivan"));
        theCustomerRepository.save(new Customer(2,"Marko"));

        theCustomerDetailsRepository.save(new CustomerDetails(1, "Ivan", "Ivić", "0914152145"));
        theCustomerDetailsRepository.save(new CustomerDetails(2, "Marko", "Matić", "0914154455"));

        theDeliveryRepository.save(new Delivery(1, new Date(2021,Calendar.DECEMBER, 10)));
        theDeliveryRepository.save(new Delivery(2, new Date(2020, Calendar.JULY, 21)));

        thePizzaRepository.save(new Pizza(1, "Carbonara", Arrays.asList(Ingredient.MOZZARELLA, Ingredient.BACON)));
        thePizzaRepository.save(new Pizza(2, "Marinara", Arrays.asList(Ingredient.MOZZARELLA, Ingredient.OREGANO)));

        thePizzaOrderRepository.save(new PizzaOrder(1,"5", Size.LARGE));
        thePizzaOrderRepository.save(new PizzaOrder(2,"3", Size.MEDIUM));

    }
}