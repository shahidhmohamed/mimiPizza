package  com.mimipizza.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mimipizza.model.Pizza;
import com.mimipizza.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {
    
    @Autowired
    private PizzaRepository pizzaRepository;
    
    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(String id) {
        return pizzaRepository.findById(id);
    }

    public void deletePizza(String id) {
        pizzaRepository.deleteById(id);
    }
}

