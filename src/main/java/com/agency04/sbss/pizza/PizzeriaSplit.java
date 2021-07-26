package com.agency04.sbss.pizza;

public class PizzeriaSplit implements PizzeriaService{
    private String name;
    private String address;

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void makePizza(Pizza pizza) {
        System.out.println("Make a " + pizza.getName() + "pizza.");
    }
}