package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.model.PizzaSize;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
@Primary
public class PizzeriaZagrebService implements PizzeriaService {
    @Value("${foo.name}")
    private String name;
    @Value("${foo.address}")
    private String address;
    private List<PizzaMenuItem> menu;

   @PostConstruct
    public void dataInitialization(){
        this.name="Pizzeria Zagreb";
        this.address="Splitska ulica 12";
        this.menu = Arrays.asList(new PizzaMenuItem("Margherita", Arrays.asList(PizzaSize.MEDIUM, PizzaSize.BIG)),
                                               new PizzaMenuItem("Marinara", Arrays.asList(PizzaSize.MEDIUM, PizzaSize.BIG)));
    }

    @PreDestroy
    public void preDestroyMessage(){
        System.out.println(">> Pizzeria Zagreb : inside of preDestroyMessage()");
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
    public void makePizza(String pizza, PizzaSize size, int quantity) {
        System.out.println("Make "+ quantity + " " + size.toString().toLowerCase(Locale.ROOT) + " " + pizza +  "pizza.");
    }
}
