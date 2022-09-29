package com.example.SpringBootExternalAPI.model;

import com.example.SpringBootExternalAPI.details.AddressDetails;
import com.example.SpringBootExternalAPI.details.CompanyDetails;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserModel implements Serializable {

    private Long id;

    private String name;

    private String username;

    private String email;

    private AddressDetails address;

    private String phone;

    private String website;

    private CompanyDetails company;

}
