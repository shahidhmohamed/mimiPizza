package com.mimipizza.decorator;

public class PizzaOrder implements Order {

    private String description = "Pizza";
    private double cost = 10.0;

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getCost() {
        return cost;
    }
}
