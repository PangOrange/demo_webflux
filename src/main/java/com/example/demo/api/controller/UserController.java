package com.example.demo.api.controller;

import com.example.demo.api.UserApi;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET,value = "/user/{id}")
    public Mono<UserVo> getUser(@PathVariable Long id) {
        return userService.getUser(id).map(u->translate(u));
    }

    @RequestMapping(method = RequestMethod.POST,value = "/user")
    public Mono<UserVo> insertUser(@RequestBody User user) {
        return userService.insertUser(user).map(u->translate(u));
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    public Mono<UserVo> updateUser(@RequestBody User user) {
        return userService.updateUser(user).map(u->translate(u));
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/user/{id}")
    public Mono<Void> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/user/{name}/{note}")
    public Flux<UserVo> findUsers(@PathVariable String name, @PathVariable String note) {
        return userService.findUsers(name,note).map(u->translate(u));
    }


    private UserVo translate(User user) {
        UserVo userVo = new UserVo();
        userVo.setId(user.getId());
        userVo.setName(user.getName());
        userVo.setNote(user.getNote());
        userVo.setSexCode(user.getSexEnum().getCode());
        userVo.setSexName(user.getSexEnum().getName());
        return userVo;
    }
}
