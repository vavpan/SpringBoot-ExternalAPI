package com.example.SpringBootExternalAPI.service;


import com.example.SpringBootExternalAPI.model.UserModel;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService{

    @Value("${external.api.url}")
    private String userApiBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public UserModel[] getAllUsers() {


        UserModel[]  result = restTemplate.getForObject(userApiBaseUrl+"/users", UserModel[].class);

        System.out.println(result);

        return result;
    }
}
