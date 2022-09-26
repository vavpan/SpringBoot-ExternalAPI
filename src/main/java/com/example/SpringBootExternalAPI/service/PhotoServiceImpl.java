package com.example.SpringBootExternalAPI.service;


import com.example.SpringBootExternalAPI.model.PhotoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PhotoServiceImpl implements PhotoService{


    @Value("${external.api.url}")
    private String photoApiBaseUrl;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public PhotoModel[] getAllPhotos() {

        PhotoModel[] result = restTemplate.getForObject(photoApiBaseUrl+"/photos", PhotoModel[].class);
        System.out.println(result);

        return result;
    }
}
