package com.agency04.sbss.pizza.model;

import java.util.List;

public class PizzaMenuItem {
    private String pizza;
    private List<Size> size;

    public PizzaMenuItem(String pizza, List<Size> size){
        this.pizza = pizza;
        this.size = size;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }
}
