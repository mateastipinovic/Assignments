package com.agency04.sbss.pizza.model;

public class FruttiDiMare implements Pizza {
    @Override
    public String getName() {
        return "FruttiDiMare";
    }
    @Override
    public String getIngredients() {
        return "Tomato sauce and seafood.";
    }
}