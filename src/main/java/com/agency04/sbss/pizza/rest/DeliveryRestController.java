package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryRestController {

    @Autowired
    private PizzaDeliveryService deliveryService;
    private List<DeliveryOrderForm> currentOrders;


    @PostConstruct
    public void loadData() {
        currentOrders = new ArrayList<>();
    }

    @PostMapping("/order")
    public ResponseEntity orderDetails (@RequestBody DeliveryOrderForm deliveryOrderForm){
        currentOrders.add(new DeliveryOrderForm(deliveryOrderForm));
        DeliveryOrderForm check = deliveryService.orderPizza(deliveryOrderForm);
        if(check == deliveryOrderForm){
            return ResponseEntity.ok(HttpStatus.CREATED).status(201).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");

    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> currentOrders(){
        return currentOrders;
    }

}

