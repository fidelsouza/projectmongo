package com.example.projectmongo.repository;

import com.example.projectmongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepositoryTraditional extends MongoRepository<User, String> {
    //
}
