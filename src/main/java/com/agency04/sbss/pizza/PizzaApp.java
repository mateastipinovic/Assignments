package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.model.Pizza;
import com.agency04.sbss.pizza.service.PizzaDeliveryService;
import com.agency04.sbss.pizza.service.PizzeriaService;
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

        //testing singleton scope annotation
        PizzeriaService theSplit = context.getBean("pizzeriaSplitService", PizzeriaService.class);
        PizzeriaService theSt = context.getBean("pizzeriaSplitService", PizzeriaService.class);
        System.out.println("Memory location for theSplit: " + theSplit);
        System.out.println("Memory location for theSt: " + theSt);

        //testing prototype scope annotation
        PizzeriaService theZagreb = context.getBean("pizzeriaZagrebService", PizzeriaService.class);
        PizzeriaService theZg = context.getBean("pizzeriaZagrebService", PizzeriaService.class);
        System.out.println("Memory location for theZagreb: " + theZagreb);
        System.out.println("Memory location for theZg: " + theZg);


        context.close();

    }

}
