package com.mimipizza.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public void placeOrder(String pizzaName) {
        System.out.println("Placing order for: " + pizzaName);
    }

    public void undoOrder(String pizzaName) {
        System.out.println("Undoing order for: " + pizzaName);
    }
}