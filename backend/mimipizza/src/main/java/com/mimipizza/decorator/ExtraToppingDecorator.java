package com.mimipizza.decorator;

public class ExtraToppingDecorator extends OrderDecorator {

    public ExtraToppingDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + ", Extra Topping";
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost() + 2.5; 
    }
}
