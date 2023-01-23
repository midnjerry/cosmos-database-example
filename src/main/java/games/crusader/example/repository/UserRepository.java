package games.crusader.example.repository;
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository;
import games.crusader.example.models.User;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveCosmosRepository<User, String> {
    Flux<User> findByFirstName(String firstName);
}
