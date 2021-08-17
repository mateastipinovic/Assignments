package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConverterClass {

    public Delivery deliveryToDeliveryForm(DeliveryForm deliveryForm){
        Delivery delivery = new Delivery();
        delivery.setSubmissionDate(deliveryForm.getSubmissionDate());
        delivery.setCustomer(customerToCustomerForm(deliveryForm.getCustomer()));
        List<PizzaOrder> pizzaOrders = new ArrayList<>();
        for (PizzaOrderForm pizzaOrder: deliveryForm.getPizzaOrders()) {
            pizzaOrders.add(pizzaOrderToPizzaOrderForm(pizzaOrder));
        }
        delivery.setPizzaOrders(pizzaOrders);
        return delivery;
    }

    public Customer customerToCustomerForm(CustomerForm customerForm){
        Customer customer = new Customer();
        customer.setUsername(customerForm.getUsername());
        customer.setCustomerDetails(detailsToDetailsForm(customerForm.getCustomerDetails()));
        List<Delivery> deliveries = new ArrayList<>();
        for (DeliveryForm deliveryForm: customerForm.getDeliveries()) {
            deliveries.add(deliveryToDeliveryForm(deliveryForm));
        }
        customer.setDeliveries(deliveries);
        return customer;
    }

    public CustomerDetails detailsToDetailsForm(CustomerDetailsForm customerDetailsForm){
        CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setFirstName(customerDetailsForm.getFirstName());
        customerDetails.setLastName(customerDetailsForm.getLastName());
        customerDetails.setPhone(customerDetailsForm.getPhone());
        return customerDetails;
    }

    public PizzaOrder pizzaOrderToPizzaOrderForm (PizzaOrderForm pizzaOrderForm){
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setSize(pizzaOrderForm.getSize());
        pizzaOrder.setQuantity(pizzaOrder.getQuantity());
        pizzaOrder.setPizza(pizzaToPizzaForm(pizzaOrderForm.getPizza()));
        return pizzaOrder;
    }

    public Pizza pizzaToPizzaForm(PizzaForm pizzaForm){
        Pizza pizza = new Pizza();
        pizza.setName(pizzaForm.getName());
        pizza.setIngredients(pizzaForm.getIngredients());
        List<PizzaOrder> orders = new ArrayList<>();
        for (PizzaOrderForm orderForm: pizzaForm.getPizzaOrders()) {
            orders.add(pizzaOrderToPizzaOrderForm(orderForm));
        }
        pizza.setPizzaOrders(orders);
        return pizza;
    }
}
