package com.example.SpringBootExternalAPI.controller;

import com.example.SpringBootExternalAPI.model.PhotoModel;
import com.example.SpringBootExternalAPI.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PhotoController {

    @Autowired
    private PhotoService photoService;

    @GetMapping("/photos")
    public PhotoModel[] getAllPhotos(){

        PhotoModel[] response = photoService.getAllPhotos();
        return response;
    }


}
