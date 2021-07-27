package com.agency04.sbss.pizza.model;

public class Carbonara implements Pizza {
    @Override
    public String getName() {
        return "Carbonara";
    }
    @Override
    public String getIngredients() {
        return "Tomato sauce, mozzarella, parmesan, eggs, and bacon.";
    }
}