package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.FruttiDiMare;
import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ApplicationContext context = SpringApplication.run(PizzaApp.class, args);

        PizzaDeliveryService theDeliveryZagreb = context.getBean("deliveryService", PizzaDeliveryService.class);
        System.out.println(theDeliveryZagreb.orderPizza(new Margherita()));
        System.out.println(theDeliveryZagreb.orderPizza(new FruttiDiMare()));

        PizzeriaService thePizzeriaSplit = context.getBean("pizzeriaSplitService", PizzeriaService.class);
        System.out.println("Initialization check: " + thePizzeriaSplit.getName() + ", " + thePizzeriaSplit.getAddress());

    }

}
