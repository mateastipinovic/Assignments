package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.model.PizzaMenuItem;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


    @RestController
    @RequestMapping("/api")
    public class PizzaRestController {

        @Autowired
        private PizzeriaService pizzeriaSplitService;
        @Autowired
        private PizzaDeliveryService deliveryService;

        @GetMapping("/pizzeria/menu")
        public List<PizzaMenuItem> getPizzeriaMenu() {
            return pizzeriaSplitService.getMenu();
        }

        @GetMapping("/pizzeria")
        public PizzeriaService getPizzeriaDetails() {
            return deliveryService.getCurrentPizzeria();
        }
    }