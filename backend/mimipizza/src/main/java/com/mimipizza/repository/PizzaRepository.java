package  com.mimipizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mimipizza.model.Pizza;

@Repository
public interface PizzaRepository extends MongoRepository<Pizza, String> {
    
}
