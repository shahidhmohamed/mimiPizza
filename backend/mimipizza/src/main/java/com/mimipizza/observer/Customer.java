package com.mimipizza.observer;


import org.springframework.stereotype.Component;

@Component
public class Customer implements Observer {
    private String name;

    public Customer() {
        // Default constructor required for Spring
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(String pizzaStatus) {
        System.out.println("Hello " + name + ", your pizza status is now: " + pizzaStatus);
    }
}
