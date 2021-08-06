package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class DeliveryService implements PizzaDeliveryService {
    @Autowired
    private PizzeriaService pizzeriaService;

    public DeliveryService(){

    }

    public String orderPizza (Pizza pizza){

        String ingredients = pizza.getIngredients().stream()
                .map(n -> String.valueOf(n).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(", ", " (", ") "));

        return  "You ordered a " + pizza.getName() + ingredients + "from " + pizzeriaService.getName() + ", " + pizzeriaService.getAddress() + ".";
    }
}