package com.mimipizza.strategy;

public interface PaymentStrategy {
    String processPayment(String orderId, double amount);
}