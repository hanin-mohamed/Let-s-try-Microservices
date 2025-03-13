package com.spring.userservice.controller;


import com.spring.userservice.entity.User;
import com.spring.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private  UserRepository userRepository;


    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id){
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User addUser(@RequestBody  User user) {
        return userRepository.save(user);
    }



}
