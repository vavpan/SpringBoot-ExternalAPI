package com.example.SpringBootExternalAPI.service;

import com.example.SpringBootExternalAPI.model.UserModel;

public interface UserService {

    public UserModel[] getAllUsers();

    public UserModel getUserById(Long id);
    public UserModel createUser(UserModel userModel);
    public UserModel updateUser(UserModel userModel, Long id);
    public void deleteUser(Long id);
}
