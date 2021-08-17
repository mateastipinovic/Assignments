package com.agency04.sbss.pizza.model;

import java.util.List;

public class CustomerForm {
    private String username;
    private CustomerDetailsForm customerDetails;
    private List<DeliveryForm> deliveries;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetailsForm getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetailsForm customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<DeliveryForm> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<DeliveryForm> deliveries) {
        this.deliveries = deliveries;
    }
}
