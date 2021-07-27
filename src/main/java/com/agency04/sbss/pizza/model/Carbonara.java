package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.List;

public class Carbonara implements Pizza {
    @Override
    public String getName() {
        return "Carbonara";
    }
    @Override
    public List<PizzaIngredient> getIngredients() {
        List ingredients = Arrays.asList(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.MOZZARELLA, PizzaIngredient.PARMESAN, PizzaIngredient.EGGS, PizzaIngredient.BACON);
        return ingredients;
    }
}