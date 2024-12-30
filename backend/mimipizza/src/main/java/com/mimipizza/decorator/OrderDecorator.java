package com.mimipizza.decorator;

public abstract class OrderDecorator implements Order {
    protected Order decoratedOrder;

    public OrderDecorator(Order decoratedOrder) {
        this.decoratedOrder = decoratedOrder;
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost();
    }
}

