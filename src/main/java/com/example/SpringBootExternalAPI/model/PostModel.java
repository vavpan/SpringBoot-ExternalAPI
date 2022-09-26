package com.example.SpringBootExternalAPI.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostModel implements Serializable {


    private Long userId;

    private Long id;
    private String title;
    private String body;

    public PostModel(){

    }

    public PostModel(Long userId, String title, String body) {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }


}
