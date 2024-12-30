package  com.mimipizza.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.mimipizza.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // Add custom query methods if needed
}
