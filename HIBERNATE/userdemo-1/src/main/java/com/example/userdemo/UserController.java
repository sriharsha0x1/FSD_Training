package com.example.userdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Save User
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public Optional<User> find(@PathVariable int id) {
        return userService.find(id);
    }

    // Get All Users
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
}