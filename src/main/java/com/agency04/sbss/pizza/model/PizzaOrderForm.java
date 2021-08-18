package com.agency04.sbss.pizza.model;

public class PizzaOrderForm {
    private String quantity;
    private Size size;
    private PizzaForm pizza;
    private DeliveryForm delivery;

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

    public PizzaForm getPizza() {
        return pizza;
    }

    public void setPizza(PizzaForm pizza) {
        this.pizza = pizza;
    }

    public DeliveryForm getDelivery() {
        return delivery;
    }

    public void setDelivery(DeliveryForm delivery) {
        this.delivery = delivery;
    }
}
