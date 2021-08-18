package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private LocalDate submissionDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "delivery")
    private List<PizzaOrder> pizzaOrders;


    public Delivery(int id, LocalDate date) {
        this.id = id;
        this.submissionDate = date;
    }

    public Delivery() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delivery delivery = (Delivery) o;
        return id == delivery.id && Objects.equals(submissionDate, delivery.submissionDate) && Objects.equals(customer, delivery.customer) && Objects.equals(pizzaOrders, delivery.pizzaOrders);
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

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<PizzaOrder> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrder> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }
}
