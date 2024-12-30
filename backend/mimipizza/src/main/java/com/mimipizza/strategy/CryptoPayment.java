package com.mimipizza.strategy;


import org.springframework.stereotype.Component;

@Component("cryptoPayment")
public class CryptoPayment implements PaymentStrategy {

    @Override
    public String processPayment(String orderId, double amount) {
        return "Payment of $" + amount + " for order " + orderId + " processed via Cryptocurrency.";
    }
}