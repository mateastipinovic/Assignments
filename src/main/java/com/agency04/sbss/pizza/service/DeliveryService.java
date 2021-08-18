package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.DAO.DeliveryRepository;
import com.agency04.sbss.pizza.DAO.PizzaOrderRepository;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.model.PizzaOrder;
import com.agency04.sbss.pizza.model.PizzaOrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeliveryService implements PizzaDeliveryService {
    @Autowired
    private PizzeriaService pizzeriaService;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;
    @Autowired
    private ConverterClass converter;

    @Autowired
    public DeliveryService(DeliveryRepository theDeliveryRepository, PizzaOrderRepository pizzaOrderRepository, ConverterClass converter) {
        deliveryRepository = theDeliveryRepository;
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.converter = converter;
    }

    public DeliveryService(){

    }

    public PizzeriaService getCurrentPizzeria(){
        return pizzeriaService;
    }

    @Override
    public void saveOrder (PizzaOrderForm pizzaOrder){
        PizzaOrder order = converter.pizzaOrderToPizzaOrderForm(pizzaOrder);
        pizzaOrderRepository.save(order);
    }

    @Override
    public void save(DeliveryForm deliveryForm) {
        Delivery delivery = converter.deliveryToDeliveryForm(deliveryForm);
        deliveryRepository.save(delivery);
    }

    @Override
    public Delivery findById(int id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);

        if (delivery.isEmpty()) {
            throw new RuntimeException("Did not find delivery id - " + id);
        }

        return delivery.get();
    }

    @Override
    public void deleteById(int id) {
        deliveryRepository.deleteById(id);
    }
}