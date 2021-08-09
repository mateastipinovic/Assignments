package com.agency04.sbss.pizza.model;

public class PizzaMenuItem {
    private String pizza;
    private String size;

    public PizzaMenuItem(String pizza, String size){
        this.pizza = pizza;
        this.size = size;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
