package com.mimipizza.model;
import lombok.Builder;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "pizzas")
@Builder
public class Pizza {
    private String size;
    private String toppings;
    private String sauce;
    
    // Getters and Setters
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    @Override
    public String toString() {
        return "Pizza {Size: " + size + ", Toppings: " + toppings + ", Sauce: " + sauce + "}";
    }
}
