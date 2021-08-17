package com.agency04.sbss.pizza.service;

import com.agency04.sbss.pizza.model.Delivery;
import com.agency04.sbss.pizza.model.DeliveryForm;
import com.agency04.sbss.pizza.model.PizzaOrderForm;

public interface PizzaDeliveryService {
        PizzeriaService getCurrentPizzeria();
        void saveOrder (PizzaOrderForm deliveryOrderForm);
        void save(DeliveryForm delivery);
        Delivery findById(int id);
        void deleteById(int id);
}
