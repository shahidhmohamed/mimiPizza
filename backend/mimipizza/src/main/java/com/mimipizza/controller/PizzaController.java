package com.mimipizza.controller;

import com.mimipizza.model.Pizza;
import com.mimipizza.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @PostMapping("/create")
    public Pizza createPizza(@RequestBody Pizza pizzaRequest) {
        // Create a new Pizza using Builder pattern
        Pizza pizza = Pizza.builder()
                .size(pizzaRequest.getSize())
                .toppings(pizzaRequest.getToppings())
                .sauce(pizzaRequest.getSauce())
                .build();

        return pizzaService.createPizza(pizza);
    }

    @GetMapping("/all")
    public List<Pizza> getAllPizzas() {
        // Get all pizzas
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> getPizzaById(@PathVariable String id) {
        // Get a pizza by its ID
        return pizzaService.getPizzaById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePizza(@PathVariable String id) {
        // Delete a pizza by its ID
        pizzaService.deletePizza(id);
    }

    @GetMapping("/example")
    public Pizza getExamplePizza() {
        // Provide an example pizza using Builder pattern
        return Pizza.builder()
                .size("Large")
                .toppings("Cheese, Pepperoni, Olives")
                .sauce("Tomato Basil")
                .build();
    }
}
