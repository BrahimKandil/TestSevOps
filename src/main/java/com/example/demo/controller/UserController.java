package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User createUserFromParam(@RequestParam String name) {
        return service.createUser(name);
    }
    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.createUserJson(user);
    }
}
