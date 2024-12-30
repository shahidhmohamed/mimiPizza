package com.mimipizza.state;

import org.springframework.stereotype.Component;

import com.mimipizza.model.Order;

@Component
public class InPreparationState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Pizza is being prepared.");
        order.setState(order.getOutForDeliveryState()); // Transition to OutForDelivery state
    }
}