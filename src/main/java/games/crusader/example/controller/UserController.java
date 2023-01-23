package games.crusader.example.controller;

import games.crusader.example.models.User;
import games.crusader.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        return userRepository.findAll().collectList().block();
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user).block();
    }
}
