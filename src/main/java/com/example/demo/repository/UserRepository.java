package com.example.demo.repository;

import com.example.demo.pojo.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends ReactiveMongoRepository<User, Long> {
    public Flux<User> findByNameLikeAndNoteLike(String name, String note);
}
