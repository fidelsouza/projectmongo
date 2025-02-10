package com.example.projectmongo.service;

import com.example.projectmongo.models.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Component
public class UserService {

   private ReactiveMongoTemplate mongoTemplate;

    public UserService(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
    public Flux<User> findProductsUsingAndOperator(String name, Integer age) {
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(Criteria.where("name")
                .is(name), Criteria.where("age")
                .gte(age)));
        return mongoTemplate.find(query, User.class);
    }
}
