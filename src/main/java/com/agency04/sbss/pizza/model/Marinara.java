package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.List;

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
