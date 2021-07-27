package com.agency04.sbss.pizza.model;

import java.util.Arrays;
import java.util.List;

public class FruttiDiMare implements Pizza {
    @Override
    public String getName() {
        return "FruttiDiMare";
    }
    @Override
    public List<PizzaIngredient> getIngredients() {
        return Arrays.asList(PizzaIngredient.TOMATO_SAUCE, PizzaIngredient.SEAFOOD);
    }
}