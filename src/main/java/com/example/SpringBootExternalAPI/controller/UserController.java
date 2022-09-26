package com.example.SpringBootExternalAPI.controller;

import com.example.SpringBootExternalAPI.model.UserModel;
import com.example.SpringBootExternalAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{userId}")
    public UserModel getUserById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserModel createUser(@RequestBody UserModel userModel){

        UserModel model = userService.createUser(userModel);

        return model;
    }

    @PutMapping("/users/{userId}")
    public UserModel updateUser(@RequestBody UserModel userModel, @PathVariable("userId") Long userId){

        UserModel model = userService.updateUser(userModel , userId);

        return model;
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable("userId") Long userId){

        userService.deleteUser(userId);
    }


}
