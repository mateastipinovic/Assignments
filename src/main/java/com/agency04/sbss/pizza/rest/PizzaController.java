package com.agency04.sbss.pizza.rest;

import com.agency04.sbss.pizza.PizzaConfig;
import com.agency04.sbss.pizza.model.FruttiDiMare;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @GetMapping("/")
    public String PizzaOrder() {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        PizzaDeliveryService theDeliveryZagreb = context.getBean("deliveryService", PizzaDeliveryService.class);

        PizzeriaService thePizzeriaSplit = context.getBean("pizzeriaSplitService", PizzeriaService.class);
        System.out.print("Initialization check: " + thePizzeriaSplit.getName() + ", " + thePizzeriaSplit.getAddress());

        context.close();

        return theDeliveryZagreb.orderPizza(new Margherita()) + " " + theDeliveryZagreb.orderPizza(new FruttiDiMare());
    }

}