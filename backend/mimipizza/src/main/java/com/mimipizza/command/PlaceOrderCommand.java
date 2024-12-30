package com.mimipizza.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mimipizza.service.OrderService;


@Component
public class PlaceOrderCommand implements Command {

    private OrderService orderService;
    private String pizzaName;

    @Autowired
    public PlaceOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    @Override
    public void execute() {
        orderService.placeOrder(pizzaName);
    }

    @Override
    public void undo() {
        orderService.undoOrder(pizzaName);
    }
}