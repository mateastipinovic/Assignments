package com.agency04.sbss.pizza.model;

import java.util.List;

public class PizzaForm {
    String name;
    List<Ingredient> ingredients;
    List<PizzaOrderForm> pizzaOrders;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<PizzaOrderForm> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrderForm> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }
}
