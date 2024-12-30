package com.mimipizza.handler;

import org.springframework.stereotype.Component;

import com.mimipizza.model.OrderCustomization;

@Component
public class ToppingsCustomizationHandler implements CustomizationHandler {

    private CustomizationHandler nextHandler;

    @Override
    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleCustomization(OrderCustomization customization) {
        if ("toppings".equalsIgnoreCase(customization.getCustomizationType())) {
            System.out.println("Handling toppings customization: " + customization.getCustomizationValue());
        } else if (nextHandler != null) {
            nextHandler.handleCustomization(customization);
        }
    }
}