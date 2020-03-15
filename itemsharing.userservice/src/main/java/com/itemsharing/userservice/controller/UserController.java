package com.itemsharing.userservice.controller;

import com.itemsharing.userservice.service.UserService;
import com.itemsharing.userservice.service.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable(name = "username") String username) {
        return userService.getUserByUserName(username);
    }
    @PostMapping(produces = "application/json", consumes = "application/json")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
