package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.model.Size;

import java.util.List;

public interface PizzeriaService {
    String getName();
    String getAddress();
    List<PizzaMenuItem> getMenu();
    void makePizza(Pizza pizza, Size size, String quantity);
}