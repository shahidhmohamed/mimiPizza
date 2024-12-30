package com.mimipizza.handler;

import com.mimipizza.model.OrderCustomization;

public interface CustomizationHandler {
    void setNextHandler(CustomizationHandler nextHandler);
    void handleCustomization(OrderCustomization customization);
}