package com.agency04.sbss.pizza;

public class PizzaDeliveryService {
    private PizzeriaService pizzeriaService;

    public PizzaDeliveryService(){

    }
    public PizzaDeliveryService(PizzeriaService thePizzeriaService){
        pizzeriaService = thePizzeriaService;
    }
    public void setPizzeriaService (PizzeriaService thePizzeriaService){
        this.pizzeriaService = thePizzeriaService;
    }

    public String orderPizza (Pizza pizza){
        return  "You ordered a " + pizza.getName() + " from " + pizzeriaService.getName() + ", " + pizzeriaService.getAddress() + ".";
    }
}