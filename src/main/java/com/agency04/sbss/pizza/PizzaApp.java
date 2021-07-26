package com.agency04.sbss.pizza;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        Margherita thePizza = new Margherita();
        PizzaDeliveryService theDeliverySplit = context.getBean("myDeliverySplit", PizzaDeliveryService.class);
        System.out.println(theDeliverySplit.orderPizza(thePizza));

        PizzaDeliveryService theDeliveryZagreb = context.getBean("myDeliveryZagreb", PizzaDeliveryService.class);
        System.out.println(theDeliveryZagreb.orderPizza(thePizza));

        context.close();

    }

}
