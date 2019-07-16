package com.example.demo.api;

import com.example.demo.pojo.User;
import com.example.demo.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Api(value = "User")
public interface UserApi {

    @ApiOperation(value = "", notes = "", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回结果")})
    @RequestMapping(method = RequestMethod.GET,value = "/user/{id}")
    Mono<UserVo> getUser(@PathVariable Long id);

    @ApiOperation(value = "", notes = "", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回结果")})
    @RequestMapping(method = RequestMethod.POST,value = "/user")
    Mono<UserVo> insertUser(@RequestBody User user);

    @ApiOperation(value = "", notes = "", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回结果")})
    @RequestMapping(method = RequestMethod.PUT,value = "/user")
    Mono<UserVo> updateUser(@RequestBody User user);

    @ApiOperation(value = "", notes = "", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回结果")})
    @RequestMapping(method = RequestMethod.DELETE,value = "/user/{id}")
    Mono<Void> deleteUser(@PathVariable Long id);

    @ApiOperation(value = "", notes = "", tags = {})
    @ApiResponses(value = {@ApiResponse(code = 200, message = "返回结果")})
    @RequestMapping(method = RequestMethod.GET,value = "/user/{name}/{note}")
    Flux<UserVo> findUsers(@PathVariable String name, @PathVariable String note);

}
