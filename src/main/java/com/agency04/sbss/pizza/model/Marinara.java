package com.agency04.sbss.pizza.model;

public class Marinara implements Pizza {
    @Override
    public String getName() {
        return "Marinara";
    }
    @Override
    public String getIngredients() {
        return "Tomato sauce, garlic and basil.";
    }
}