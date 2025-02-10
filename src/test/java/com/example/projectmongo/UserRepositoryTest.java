package com.example.projectmongo;

import com.example.projectmongo.models.User;
import com.example.projectmongo.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

//@DataJpaTest
@RunWith(SpringRunner.class)
@DataMongoTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

//    @Autowired
//    UserService userService;

    @Autowired
    ReactiveMongoTemplate mongoTemplate;

//    @Before
//    public void setUp() throws Exception {
//        fooRepository.save(new Foo());
//    }

    @Test
    public void shouldBeNotEmpty() {
        var list = userRepository.findAll();
        Assert.assertNotNull(list);
    }

    @Test
    public void test(){
        Query query = new Query();
        query.addCriteria(new Criteria().andOperator(Criteria.where("name")
                .is("Fidel"), Criteria.where("age")
                .gte(31)));
        var ret =  mongoTemplate.find(query, User.class);

        Assert.assertNotNull(ret);
    }

//    @Test
//    public void testUserService() {
//        var list = userService.findProductsUsingAndOperator("Fidel", 31);
//        Assert.assertNotNull(list);
//    }
}
