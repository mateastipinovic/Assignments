package com.agency04.sbss.pizza.model;

import java.util.List;

public class PizzaMenuItem {
    private String pizza;
    private List<PizzaSize> size;

    public PizzaMenuItem(String pizza, List<PizzaSize> size){
        this.pizza = pizza;
        this.size = size;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public List<PizzaSize> getSize() {
        return size;
    }

    public void setSize(List<PizzaSize> size) {
        this.size = size;
    }
}
