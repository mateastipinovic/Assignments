package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class PizzaOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String quantity;

    @Column
    @Enumerated(EnumType.STRING)
    private Size size;

    @ManyToOne
    @JoinColumn(name="pizza_id")
    private Pizza pizza;

    @ManyToOne
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    public PizzaOrder(int id, String quantity, Size size) {
        this.id = id;
        this.quantity = quantity;
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PizzaOrder that = (PizzaOrder) o;
        return id == that.id && Objects.equals(quantity, that.quantity) && size == that.size && Objects.equals(pizza, that.pizza) && Objects.equals(delivery, that.delivery);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public PizzaOrder(PizzaOrder pizzaOrder) {
        this.id = pizzaOrder.id;
        this.pizza = pizzaOrder.pizza;
        this.quantity = pizzaOrder.quantity;
        this.size = pizzaOrder.size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


}
