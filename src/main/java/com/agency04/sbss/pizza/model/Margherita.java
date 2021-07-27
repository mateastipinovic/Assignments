package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.List;

public class Margherita implements Pizza {
    @Override
    public String getName() {
        return "Margherita";
    }
    @Override
    public List<PizzaIngredient> getIngredients() {
        List ingredients = Arrays.asList(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.MOZZARELLA, PizzaIngredient.OREGANO);
        return ingredients;
    }
}