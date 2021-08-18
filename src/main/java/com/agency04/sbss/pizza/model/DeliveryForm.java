package com.agency04.sbss.pizza.model;

import java.time.LocalDate;
import java.util.List;

public class DeliveryForm {
    private LocalDate submissionDate;
    private CustomerForm customer;
    private List<PizzaOrderForm> pizzaOrders;

    public DeliveryForm(LocalDate date) {
        this.submissionDate = date;
    }

    public LocalDate getSubmissionDate() {
        return submissionDate;
    }

    public void setSubmissionDate(LocalDate submissionDate) {
        this.submissionDate = submissionDate;
    }

    public CustomerForm getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerForm customer) {
        this.customer = customer;
    }

    public List<PizzaOrderForm> getPizzaOrders() {
        return pizzaOrders;
    }

    public void setPizzaOrders(List<PizzaOrderForm> pizzaOrders) {
        this.pizzaOrders = pizzaOrders;
    }
}
