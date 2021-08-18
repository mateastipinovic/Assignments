package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.model.Size;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class PizzeriaSplitService implements PizzeriaService {
    private String name;
    private String address;
    private List<PizzaMenuItem> menu;


    @PostConstruct
    public void dataInitialization(){
        this.name="Pizzeria Split";
        this.address="Vukovarska ulica 15";
        this.menu = Arrays.asList(new PizzaMenuItem("Carbonara", Arrays.asList(Size.SMALL, Size.MEDIUM, Size.LARGE)),
                                  new PizzaMenuItem("FruttiDiMare", Arrays.asList(Size.SMALL, Size.MEDIUM, Size.LARGE)));
    }
    @PreDestroy
    public void preDestroyMessage(){
        System.out.println(">> Pizzeria Split : inside of preDestroyMessage()");
    }
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
    public List<PizzaMenuItem> getMenu() {
        return menu;
    }

    @Override
    public void makePizza(Pizza pizza, Size size, String quantity) {
        System.out.println("Make "+ quantity + " " + size.toString().toLowerCase(Locale.ROOT) + " " + pizza +  "pizza.");
    }
}