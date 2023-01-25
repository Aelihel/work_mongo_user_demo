package work.ua.mongo_user.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import work.ua.mongo_user.domain.User;

import java.util.Optional;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String> {

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
