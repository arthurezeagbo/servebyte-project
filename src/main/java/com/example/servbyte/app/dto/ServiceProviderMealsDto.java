package com.example.servbyte.app.dto;

import com.example.servbyte.app.model.Meal;
import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Blob;
import java.util.List;

@Data
public class ServiceProviderMealsDto {

    private Long id;
    private String name;
    private String email;
    private String city;

    private Blob logo;
    private String phoneNumber;

    private List<Meal> mealList;

}

