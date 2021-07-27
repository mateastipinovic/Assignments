package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;

public interface PizzeriaService {
    public String getName();
    public String getAddress();
    public void makePizza(Pizza pizza);
}