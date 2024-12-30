package com.mimipizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mimipizza.observer.Customer;
import com.mimipizza.observer.PizzaOrder;

@RestController
@RequestMapping("/pizza")
public class PizzaOrderController {

    @Autowired
    private PizzaOrder pizzaOrder;

    @PostMapping("/register")
    public String registerCustomer(@RequestParam String name) {
        pizzaOrder.registerObserver(new Customer());
        return "Customer " + name + " registered for notifications.";
    }

    @PostMapping("/status")
    public String updateStatus(@RequestParam String status) {
        pizzaOrder.setPizzaStatus(status);
        return "Pizza status updated to: " + status;
    }
}
