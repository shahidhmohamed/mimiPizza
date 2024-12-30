package com.mimipizza.handler;

import org.springframework.stereotype.Component;

import com.mimipizza.model.OrderCustomization;

@Component
public class CrustTypeCustomizationHandler implements CustomizationHandler {

    private CustomizationHandler nextHandler;

    @Override
    public void setNextHandler(CustomizationHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleCustomization(OrderCustomization customization) {
        if ("crust".equalsIgnoreCase(customization.getCustomizationType())) {
            System.out.println("Handling crust customization: " + customization.getCustomizationValue());
        } else if (nextHandler != null) {
            nextHandler.handleCustomization(customization);
        }
    }
}
