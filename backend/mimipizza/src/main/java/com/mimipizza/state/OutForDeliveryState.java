package com.mimipizza.state;

import org.springframework.stereotype.Component;

import com.mimipizza.model.Order;

@Component
public class OutForDeliveryState implements OrderState {
    @Override
    public void processOrder(Order order) {
        System.out.println("Pizza is out for delivery.");
        // If there's a Delivered state, transition here; for now, we end the flow
    }
}
