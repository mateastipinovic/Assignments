package com.agency04.sbss.pizza.model;

public class Customer {
    private int customerId;
    private String userName;
    private String address;

    public Customer(Customer customer){
        this.customerId = customer.customerId;
        this.userName=customer.userName;
        this.address= customer.address;
    }
    public Customer(int customerId, String username, String address){
        this.customerId = customerId;
        this.userName=username;
        this.address= address;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddress() {
        return address;
    }

}
