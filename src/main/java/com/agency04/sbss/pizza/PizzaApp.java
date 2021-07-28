package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Pizza theMargherita = context.getBean("margherita", Pizza.class);
        Pizza theFruttiDiMare = context.getBean("fruttiDiMare", Pizza.class);
        PizzaDeliveryService theDeliveryZagreb = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        System.out.println(theDeliveryZagreb.orderPizza(theMargherita));
        System.out.println(theDeliveryZagreb.orderPizza(theFruttiDiMare));

        context.close();

    }

}
