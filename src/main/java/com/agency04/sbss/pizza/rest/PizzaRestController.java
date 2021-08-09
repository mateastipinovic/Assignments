package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PizzaRestController {

    @Autowired
    private PizzeriaService pizzeriaSplitService;
    @Autowired
    private PizzaDeliveryService deliveryService;
    private List<Customer> customers;
    private List<DeliveryOrderForm> currentOrders;

    @PostConstruct
    public void loadData(){
        customers = new ArrayList<>();
        customers.add(new Customer(0,"Ivan Ivić", "Ivićeva 32"));
        customers.add(new Customer(1,"Matko Matić", "Matićeva 55"));
        customers.add(new Customer(2,"Stipe Stipić", "Stipićeva 1"));
        currentOrders = new ArrayList<>();

    }
    @GetMapping("/pizzeria/menu")
    public List<PizzaMenuItem> getPizzeriaMenu (){
        return pizzeriaSplitService.getMenu();
    }

    @GetMapping("/pizzeria")
    public PizzeriaService getPizzeriaDetails(){
        return deliveryService.getCurrentPizzeria();
    }

    @GetMapping("/customer/{username}")
    public Customer getCustomer(@PathVariable String username){
        return customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null);
    }

    @DeleteMapping("/customer/{username}")
    public ResponseEntity deleteCustomer(@PathVariable String username) {
        customers.remove(customers.stream().filter(x -> x.getUserName().equals(username)).findFirst().orElse(null));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/customer")
    public ResponseEntity registerCustomer(@RequestBody Customer customer) {
        customers.add(new Customer(customer));
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/customer")
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        Customer temp = customers.stream().filter(x -> x.getCustomerId() == customer.getCustomerId() ).findFirst().orElse(null);
        if(temp != null) {
            int index = customers.indexOf(temp);
            customers.set(index, customer);
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }

    @PostMapping("/delivery/order")
    public ResponseEntity orderDetails (@RequestBody DeliveryOrderForm deliveryOrderForm){
        currentOrders.add(new DeliveryOrderForm(deliveryOrderForm));
        deliveryService.orderPizza(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("delivery/list")
    public List<DeliveryOrderForm> currentOrders(){
        return currentOrders;
    }

}