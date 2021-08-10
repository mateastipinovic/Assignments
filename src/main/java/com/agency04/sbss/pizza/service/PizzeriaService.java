package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.model.PizzaSize;

import java.util.List;

public interface PizzeriaService {
    String getName();
    String getAddress();
    List<PizzaMenuItem> getMenu();
    void makePizza(String pizza, PizzaSize size, int quantity);
}