package com.mimipizza.observer;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PizzaOrder implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private String pizzaStatus;

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(pizzaStatus);
        }
    }

    public void setPizzaStatus(String pizzaStatus) {
        this.pizzaStatus = pizzaStatus;
        notifyObservers();
    }
}
