package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.DeliveryOrderForm;

public interface PizzaDeliveryService {
        public PizzeriaService getCurrentPizzeria();
        public String orderPizza (DeliveryOrderForm deliveryOrderForm);
}
