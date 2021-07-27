package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Margherita;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Margherita thePizza = new Margherita();
        PizzaDeliveryService theDeliveryZagreb = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);
        System.out.println(theDeliveryZagreb.orderPizza(thePizza));

        context.close();

    }

}
