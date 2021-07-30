package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class PizzaDeliveryService {
    @Autowired
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){

    }

    public String orderPizza (Pizza pizza){

        String ingredients = pizza.getIngredients().stream()
                .map(n -> String.valueOf(n).toLowerCase(Locale.ROOT))
                .collect(Collectors.joining(", ", " (", ") "));

        return  "You ordered a " + pizza.getName() + ingredients + "from " + pizzeriaService.getName() + ", " + pizzeriaService.getAddress() + ".";
    }
}