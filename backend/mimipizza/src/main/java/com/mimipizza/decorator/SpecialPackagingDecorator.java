package com.mimipizza.decorator;

public class SpecialPackagingDecorator extends OrderDecorator {

    public SpecialPackagingDecorator(Order decoratedOrder) {
        super(decoratedOrder);
    }

    @Override
    public String getDescription() {
        return decoratedOrder.getDescription() + ", Special Packaging";
    }

    @Override
    public double getCost() {
        return decoratedOrder.getCost() + 1.5; // Adding cost for special packaging
    }
}

