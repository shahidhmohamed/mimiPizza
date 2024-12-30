package com.mimipizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.mimipizza.handler.CustomizationHandlerChain;
import com.mimipizza.model.OrderCustomization;

@RestController
@RequestMapping("/pizza")
public class PizzaCustomizationController {

    private final CustomizationHandlerChain customizationHandlerChain;

    @Autowired
    public PizzaCustomizationController(CustomizationHandlerChain customizationHandlerChain) {
        this.customizationHandlerChain = customizationHandlerChain;
    }

    @PostMapping("/customize")
    public String customizePizza(@RequestParam String customizationType, @RequestParam String customizationValue) {
        OrderCustomization customization = new OrderCustomization(customizationType, customizationValue);
        customizationHandlerChain.processCustomization(customization);
        return "Customization processed for " + customizationType + ": " + customizationValue;
    }
}
