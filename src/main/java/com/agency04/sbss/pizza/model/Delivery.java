package com.agency04.sbss.pizza.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private Date submissionDate;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "delivery")
    private List<PizzaOrder> pizzaOrders;

    public Delivery(){

    };

    public Delivery(int id, Date date) {
        this.id = id;
        this.submissionDate = date;
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

    public Date getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(Date submissionDate) {
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
