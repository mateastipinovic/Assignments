package com.agency04.sbss.pizza;

import com.agency04.sbss.pizza.service.PizzeriaService;
import com.agency04.sbss.pizza.service.PizzeriaZagrebService;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.agency04.sbss.pizza")
@PropertySource("classpath:application.properties")
public class PizzaConfig {

   @Bean
   @Primary
    public PizzeriaService pizzeriaZagreb(){
        return new PizzeriaZagrebService();
    }

}
