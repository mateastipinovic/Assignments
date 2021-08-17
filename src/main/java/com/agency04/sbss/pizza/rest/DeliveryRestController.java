package com.agency04.sbss.pizza.rest;


import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.model.PizzaOrderForm;
import com.agency04.sbss.pizza.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryRestController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryRestController(DeliveryService theDeliveryService){
        deliveryService = theDeliveryService;
    }

    @PostMapping("/order")
    public PizzaOrderForm orderDetails (@RequestBody PizzaOrderForm pizzaOrder){
        deliveryService.saveOrder(pizzaOrder);
        deliveryService.save(new DeliveryForm(LocalDate.now()));
        return pizzaOrder;

    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable int id) {
        Delivery delivery = deliveryService.findById(id);
        if(delivery == null ){
            throw new CustomerNotFoundException("Delivery with id " + id + " doesn't exist.");
        }
        return delivery;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDelivery(@PathVariable int id) {
        Delivery tempDelivery = deliveryService.findById(id);

        if (tempDelivery == null) {
            throw new CustomerNotFoundException("Delivery with id " + id + " doesn't exist.");
        }

        deliveryService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/")
    public DeliveryForm createDelivery(@RequestBody DeliveryForm delivery) {
        deliveryService.save(delivery);
        return  delivery;
    }

    @PutMapping("/")
    public DeliveryForm updateDelivery (@RequestBody DeliveryForm delivery) {
        deliveryService.save(delivery);
        return delivery;
    }

}

