package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    String name;

    @ElementCollection
    List<Ingredient> ingredients;

    @OneToMany(mappedBy = "pizza")
    List<PizzaOrder> pizzaOrders;

    public Pizza(){

    };

    public Pizza(int id, String name, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return id == pizza.id && Objects.equals(name, pizza.name) && Objects.equals(ingredients, pizza.ingredients) && Objects.equals(pizzaOrders, pizza.pizzaOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


    public List<PizzaOrder> getPizzaOrder() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }

}
