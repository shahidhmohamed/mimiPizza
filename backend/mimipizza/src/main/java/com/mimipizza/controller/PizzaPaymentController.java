package com.mimipizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mimipizza.context.PaymentContext;

@RestController
@RequestMapping("/pizza")
public class PizzaPaymentController {

    private final com.mimipizza.context.PaymentContext paymentContext;

    @Autowired
    public PizzaPaymentController(PaymentContext paymentContext) {
        this.paymentContext = paymentContext;
    }

    @PostMapping("/pay")
    public String payForPizza(@RequestParam String method, @RequestParam String orderId, @RequestParam double amount) {
        return paymentContext.executePayment(method, orderId, amount);
    }
}
