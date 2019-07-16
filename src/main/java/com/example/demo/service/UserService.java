package com.example.demo.service;

import com.example.demo.pojo.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<User> getUser(Long id);

    Mono<User> insertUser(User user);

    Mono<User> updateUser(User user);

    Mono<Void> deleteUser(Long id);

    Flux<User> findUsers(String name, String note);

}
