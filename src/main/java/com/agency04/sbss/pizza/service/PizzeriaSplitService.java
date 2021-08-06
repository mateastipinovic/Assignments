package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PizzeriaSplitService implements PizzeriaService {
    private String name;
    private String address;

    @PostConstruct
    public void dataInitialization(){
        this.name="Pizzeria Split";
        this.address="Vukovarska ulica 15";
    }
    @PreDestroy
    public void preDestroyMessage(){
        System.out.println(">> Pizzeria Split : inside of preDestroyMessage()");
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void makePizza(Pizza pizza) {
        System.out.println("Make a " + pizza.getName() + "pizza.");
    }
}