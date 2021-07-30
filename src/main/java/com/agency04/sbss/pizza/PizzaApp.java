package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PizzaApp {

    public static void main(String[] args) {
        // Add some pizza code
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PizzaConfig.class);

        Pizza theMargherita = context.getBean("margherita", Pizza.class);
        Pizza theFruttiDiMare = context.getBean("fruttiDiMare", Pizza.class);
        PizzaDeliveryService theDeliverySplit = context.getBean("pizzaDeliveryService", PizzaDeliveryService.class);

        System.out.println(theDeliverySplit.orderPizza(theMargherita));
        System.out.println(theDeliverySplit.orderPizza(theFruttiDiMare));

        context.close();

    }

}
