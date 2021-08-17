package com.agency04.sbss.pizza.model;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String username;

    @OneToOne
    @JoinColumn(name = "customerDetails_id")
    private CustomerDetails customerDetails;

    @OneToMany(mappedBy = "customer")
    private List<Delivery> deliveries;

    public Customer(int i, String username) {
        this.id=i;
        this.username=username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && Objects.equals(username, customer.username) && Objects.equals(customerDetails, customer.customerDetails) && Objects.equals(deliveries, customer.deliveries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Customer(Customer customer){
        this.id = customer.id;
        this.username=customer.username;
        this.customerDetails = customer.customerDetails;
        this.deliveries = customer.deliveries;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Delivery> deliveries) {
        this.deliveries = deliveries;
    }
}
