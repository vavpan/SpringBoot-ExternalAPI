package com.example.SpringBootExternalAPI.service;



import com.example.SpringBootExternalAPI.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
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

    @Override
    public UserModel getUserById(Long userId) {

        UserModel result = restTemplate.getForObject(userApiBaseUrl+"/users/"+userId  ,UserModel.class);

        return result;

    }

    @Override
    public UserModel createUser(UserModel userModel) {
        UserModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<UserModel> httpEntity = new HttpEntity<>(userModel , headers);
        ResponseEntity<UserModel> newUserEntity = restTemplate.postForEntity(userApiBaseUrl+"/users" , httpEntity , UserModel.class);

        if (newUserEntity.getStatusCode() == HttpStatus.CREATED){
            model = newUserEntity.getBody();
        }

        return model;
    }

    @Override
    public UserModel updateUser(UserModel userModel , Long id) {

        UserModel model = null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<UserModel> httpEntity = new HttpEntity<>(userModel , headers);
        ResponseEntity<UserModel> updatedUserEntity = restTemplate.exchange(userApiBaseUrl+"/users/{id}", HttpMethod.PUT, httpEntity , UserModel.class , id);

        if (updatedUserEntity.getStatusCode() == HttpStatus.OK){
            model = updatedUserEntity.getBody();
        }


        return model;
    }

    @Override
    public void deleteUser(Long id) {

        restTemplate.delete(userApiBaseUrl+"/users/{id}",id);
    }


}
