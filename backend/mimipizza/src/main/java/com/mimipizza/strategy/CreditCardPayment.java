package com.mimipizza.strategy;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPayment implements PaymentStrategy {

    @Override
    public String processPayment(String orderId, double amount) {
        return "Payment of $" + amount + " for order " + orderId + " processed via Credit Card.";
    }
}