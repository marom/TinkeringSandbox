package com.marom.gallerybackend.controllers;

import com.marom.gallerybackend.model.User;
import com.marom.gallerybackend.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String login() {
        return "";
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.save(user);
    }
}
