package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.DAO.DeliveryRepository;
import com.agency04.sbss.pizza.DAO.PizzaOrderRepository;
import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.PizzaOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DeliveryService implements PizzaDeliveryService {
    @Autowired
    private PizzeriaService pizzeriaService;
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PizzaOrderRepository pizzaOrderRepository;

    @Autowired
    public DeliveryService(DeliveryRepository theDeliveryRepository) {
        deliveryRepository = theDeliveryRepository;
    }

    public DeliveryService(){

    }

    public PizzeriaService getCurrentPizzeria(){
        return pizzeriaService;
    }


    public PizzaOrder orderPizza (PizzaOrder pizzaOrder){ ;
        pizzaOrderRepository.save(pizzaOrder);
        return  pizzaOrder;
    }
}