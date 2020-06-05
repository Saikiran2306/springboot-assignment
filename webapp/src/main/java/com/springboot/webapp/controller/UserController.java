package com.springboot.webapp.controller;

import com.springboot.webapp.entity.User;
import com.springboot.webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }


    @GetMapping("/userofid/{userId}")
    public User getUser(@PathVariable int userId) {
        User theUser = userService.findById(userId);
        return theUser;
    }
}
