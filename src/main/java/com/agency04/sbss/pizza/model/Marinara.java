package com.agency04.sbss.pizza.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }
    @Override
    public List<PizzaIngredient> getIngredients() {
        return Arrays.asList(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.GARLIC, PizzaIngredient.BASIL);
    }
}
