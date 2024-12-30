package com.mimipizza.state;

import org.springframework.stereotype.Component;

import com.mimipizza.model.Order;


@Component
public class PlacedState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Order has been placed. Preparing the pizza...");
        order.setState(order.getInPreparationState());
    }
}