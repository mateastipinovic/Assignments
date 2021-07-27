package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PizzaDeliveryService {
    @Autowired
    @Qualifier("pizzeriaZagrebService")
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){

    }

    public String orderPizza (Pizza pizza){
        return  "You ordered a " + pizza.getName() + " from " + pizzeriaService.getName() + ", " + pizzeriaService.getAddress() + ".";
    }
}