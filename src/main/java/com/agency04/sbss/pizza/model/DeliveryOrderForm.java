package com.agency04.sbss.pizza.model;

public class DeliveryOrderForm {
    private Customer customer;
    private String pizza;
    private PizzaSize pizzaSize;
    private int quantity;

    public  DeliveryOrderForm(){

    }

    public DeliveryOrderForm(DeliveryOrderForm deliveryOrderForm) {
        this.customer = deliveryOrderForm.customer;
        this.pizza = deliveryOrderForm.pizza;
        this.pizzaSize = deliveryOrderForm.pizzaSize;
        this.quantity = deliveryOrderForm.quantity;
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getPizza() {
        return pizza;
    }

    public PizzaSize getPizzaSize() {
        return pizzaSize;
    }

    public int getQuantity() {
        return quantity;
    }

}
