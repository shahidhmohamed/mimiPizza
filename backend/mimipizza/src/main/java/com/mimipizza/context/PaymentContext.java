package com.mimipizza.context;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mimipizza.strategy.PaymentStrategy;

import java.util.Map;

@Component
public class PaymentContext {

    private final Map<String, PaymentStrategy> paymentStrategies;

    @Autowired
    public PaymentContext(Map<String, PaymentStrategy> paymentStrategies) {
        this.paymentStrategies = paymentStrategies;
    }

    public String executePayment(String method, String orderId, double amount) {
        PaymentStrategy strategy = paymentStrategies.get(method);
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid payment method: " + method);
        }
        return strategy.processPayment(orderId, amount);
    }
}