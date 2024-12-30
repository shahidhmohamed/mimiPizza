package com.mimipizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mimipizza.model.Order;

@RestController
public class OrderController {

    @Autowired
    private Order order;

    @GetMapping("/order/process")
    public String processOrder() {
        order.processOrder(); // Processes the order through its states
        return "Order is now in state: " + order.getCurrentState().getClass().getSimpleName();
    }
}