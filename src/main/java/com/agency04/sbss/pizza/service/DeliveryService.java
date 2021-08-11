package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements PizzaDeliveryService {
    @Autowired
    private PizzeriaService pizzeriaService;

    public DeliveryService(){

    }

    public PizzeriaService getCurrentPizzeria(){
        return pizzeriaService;
    }


    @Override
    public DeliveryOrderForm orderPizza (DeliveryOrderForm deliveryOrderForm){
        pizzeriaService.makePizza(deliveryOrderForm.getPizza(), deliveryOrderForm.getPizzaSize(), deliveryOrderForm.getQuantity());
        return  deliveryOrderForm;
    }
}