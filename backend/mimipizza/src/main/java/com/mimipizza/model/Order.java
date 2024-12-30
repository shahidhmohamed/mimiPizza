package com.mimipizza.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mimipizza.state.InPreparationState;
import com.mimipizza.state.OrderState;
import com.mimipizza.state.OutForDeliveryState;
import com.mimipizza.state.PlacedState;


@Component
public class Order {

    private OrderState currentState;

    // Declare the different states
    @Autowired
    private PlacedState placedState;
    
    @Autowired
    private InPreparationState inPreparationState;
    
    @Autowired
    private OutForDeliveryState outForDeliveryState;

    public Order() {
        // Default constructor
    }

    // Initialize the state after bean construction
    @jakarta.annotation.PostConstruct
    public void init() {
        this.currentState = placedState;  // Default to PlacedState
    }

    public void setState(OrderState state) {
        this.currentState = state;
    }

    public void processOrder() {
        if (currentState != null) {
            currentState.processOrder(this);
        } else {
            System.out.println("Error: Current state is not initialized.");
        }
    }

    // Getters for each state
    public OrderState getPlacedState() {
        return placedState;
    }

    public OrderState getInPreparationState() {
        return inPreparationState;
    }

    public OrderState getOutForDeliveryState() {
        return outForDeliveryState;
    }

    public OrderState getCurrentState() {
        return currentState;
    }
}
