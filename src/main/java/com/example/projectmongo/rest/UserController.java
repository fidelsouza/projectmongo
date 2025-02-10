package com.example.projectmongo.rest;

import com.example.projectmongo.models.User;
import com.example.projectmongo.repository.UserRepository;
import com.example.projectmongo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    UserRepository userRepository;

    UserService userService;

    public UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping("/list-all")
    public ResponseEntity<Flux<User>> getUsers() {
        var list = userRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @PostMapping("/user")
    public ResponseEntity<Mono<User>> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @GetMapping("/list")
    public ResponseEntity<Flux<User>> getUsers(@RequestParam String name, @RequestParam Integer age) {
        var list = userService.findProductsUsingAndOperator(name, age);
        return ResponseEntity.ok(list);
    }


}
