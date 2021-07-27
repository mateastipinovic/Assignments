package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaIngredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class PizzaDeliveryService {
    @Autowired
    @Qualifier("pizzeriaZagrebService")
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){

    }

    public String orderPizza (Pizza pizza){
        String ingredients = "";
        for (PizzaIngredient ingr : pizza.getIngredients())
        {
            ingredients=ingredients.concat(ingr.toString()).concat(" ").toLowerCase(Locale.ROOT);
        }
        return  "You ordered a " + pizza.getName() + " / " + ingredients + "/ from " + pizzeriaService.getName() + ", " + pizzeriaService.getAddress() + ".";
    }
}