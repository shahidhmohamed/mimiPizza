package com.mimipizza.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mimipizza.model.OrderCustomization;

@Component
public class CustomizationHandlerChain {

    private final SizeCustomizationHandler sizeCustomizationHandler;
    private final ToppingsCustomizationHandler toppingsCustomizationHandler;
    private final CrustTypeCustomizationHandler crustTypeCustomizationHandler;

    @Autowired
    public CustomizationHandlerChain(
        SizeCustomizationHandler sizeCustomizationHandler,
        ToppingsCustomizationHandler toppingsCustomizationHandler,
        CrustTypeCustomizationHandler crustTypeCustomizationHandler
    ) {
        this.sizeCustomizationHandler = sizeCustomizationHandler;
        this.toppingsCustomizationHandler = toppingsCustomizationHandler;
        this.crustTypeCustomizationHandler = crustTypeCustomizationHandler;

        // Setting up the chain
        sizeCustomizationHandler.setNextHandler(toppingsCustomizationHandler);
        toppingsCustomizationHandler.setNextHandler(crustTypeCustomizationHandler);
    }

    public void processCustomization(OrderCustomization customization) {
        sizeCustomizationHandler.handleCustomization(customization);
    }
}