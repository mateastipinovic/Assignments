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
        deliveryService.orderPizza(deliveryOrderForm);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<DeliveryOrderForm> currentOrders(){
        return currentOrders;
    }

}

