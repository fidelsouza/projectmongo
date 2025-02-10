package com.example.projectmongo.repository;

import com.example.projectmongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    //
    @Query("{name:'?0'}")
    Mono<User> findByName(String name);
}
