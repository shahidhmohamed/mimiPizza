package com.mimipizza.controller;

import org.springframework.web.bind.annotation.*;

import com.mimipizza.decorator.ExtraToppingDecorator;
import com.mimipizza.decorator.Order;
import com.mimipizza.decorator.PizzaOrder;
import com.mimipizza.decorator.SpecialPackagingDecorator;

@RestController
@RequestMapping("/orders")
public class DecoratorOrderController {

    @PostMapping("/create")
    public String createOrder(@RequestParam(defaultValue = "false") boolean extraToppings,
                              @RequestParam(defaultValue = "false") boolean specialPackaging) {
        
        Order pizzaOrder = new PizzaOrder();

        if (extraToppings) {
            pizzaOrder = new ExtraToppingDecorator(pizzaOrder);
        }

        if (specialPackaging) {
            pizzaOrder = new SpecialPackagingDecorator(pizzaOrder);
        }

        String orderDescription = pizzaOrder.getDescription();
        double orderCost = pizzaOrder.getCost();

        return "Extra Cost: $" + orderCost;
    }
}
