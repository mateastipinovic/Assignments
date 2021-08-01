package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.PizzaConfig;
import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @GetMapping("/")
    public String PizzaOrder() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        Pizza theMargherita = context.getBean("margherita", Pizza.class);
        Pizza theFruttiDiMare = context.getBean("fruttiDiMare", Pizza.class);
        PizzaDeliveryService theDeliveryZagreb = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);

        context.close();

        return theDeliveryZagreb.orderPizza(theMargherita) + " " + theDeliveryZagreb.orderPizza(theFruttiDiMare);
    }

}