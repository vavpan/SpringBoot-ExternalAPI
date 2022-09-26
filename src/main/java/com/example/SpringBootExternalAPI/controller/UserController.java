package com.example.SpringBootExternalAPI.controller;

import com.example.SpringBootExternalAPI.model.UserModel;
import com.example.SpringBootExternalAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public UserModel[] getAllUsers(){
        UserModel[] response = userService.getAllUsers();
        return response;
    }

}
