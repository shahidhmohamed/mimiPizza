package com.mimipizza.model;

public class OrderCustomization {
    private String customizationType;
    private String customizationValue;

    public OrderCustomization(String customizationType, String customizationValue) {
        this.customizationType = customizationType;
        this.customizationValue = customizationValue;
    }

    public String getCustomizationType() {
        return customizationType;
    }

    public String getCustomizationValue() {
        return customizationValue;
    }

    public void setCustomizationValue(String customizationValue) {
        this.customizationValue = customizationValue;
    }
}