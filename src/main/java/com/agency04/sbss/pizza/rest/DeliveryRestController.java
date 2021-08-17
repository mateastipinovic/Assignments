package com.agency04.sbss.pizza.rest;


import com.agency04.sbss.pizza.DAO.DeliveryRepository;
import com.agency04.sbss.pizza.DAO.PizzaOrderRepository;
import com.agency04.sbss.pizza.model.Customer;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryRestController {

    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public DeliveryRestController(DeliveryRepository theDeliveryRepository, PizzaOrderRepository pizzaOrderRepository){
        deliveryRepository = theDeliveryRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
    }

    @PostMapping("/order")
    public PizzaOrder orderDetails (@RequestBody PizzaOrder pizzaOrder){
        pizzaOrderRepository.save(pizzaOrder);
        deliveryRepository.save(new Delivery(0, new Date()));

        return pizzaOrder;

    }

    @GetMapping("/{id}")
    public Delivery getDelivery(@PathVariable int id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if(delivery.isPresent()){
            return delivery.get();
        }
        throw new CustomerNotFoundException("Delivery with id " + id + " doesn't exist.");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDelivery(@PathVariable int id) {
        Optional<Delivery> tempDelivery = deliveryRepository.findById(id);

        if (!tempDelivery.isPresent()) {
            throw new CustomerNotFoundException("Delivery with id " + id + " doesn't exist.");
        }

        deliveryRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/")
    public Delivery createDelivery(@RequestBody Delivery delivery) {
        delivery.setId(0);
        deliveryRepository.save(delivery);
        return  delivery;
    }

    @PutMapping("/")
    public ResponseEntity updateDelivery (@RequestBody Delivery delivery) {
        Optional<Delivery> tempDelivery = deliveryRepository.findById(delivery.getId());
        if (tempDelivery.isPresent()) {
            deliveryRepository.save(tempDelivery.get());
            if(delivery.equals(deliveryRepository.findById(delivery.getId()))){
                return  ResponseEntity.ok(HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Bad request");
    }

}

