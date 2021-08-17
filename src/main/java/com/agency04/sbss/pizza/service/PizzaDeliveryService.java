package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.PizzaOrder;

public interface PizzaDeliveryService {
        public PizzeriaService getCurrentPizzeria();
        public PizzaOrder orderPizza (PizzaOrder deliveryOrderForm);
}
