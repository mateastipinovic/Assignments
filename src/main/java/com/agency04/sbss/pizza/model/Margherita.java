package com.agency04.sbss.pizza.model;

public class Margherita implements Pizza {
    @Override
    public String getName() {
        return "Margherita";
    }
    @Override
    public String getIngredients() {
        return "Tomato sauce, mozzarella, and oregano.";
    }
}