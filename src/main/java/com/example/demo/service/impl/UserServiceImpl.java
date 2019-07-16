package com.example.demo.service.impl;

import com.example.demo.pojo.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Resource
    private MongoTemplate mongoTemplate;
    @Override
    public Mono<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Mono<User> insertUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> updateUser(User user) {
        Query q=new Query(new Criteria("id").is(user.getId()));
        Update update=new Update().set("name", user.getName()).set("sexEnum", user.getSexEnum()).set("note", user.getNote());
        mongoTemplate.updateMulti(q, update, User.class);
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> deleteUser(Long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Flux<User> findUsers(String name, String note) {
        return userRepository.findByNameLikeAndNoteLike(name, note);
    }
}
