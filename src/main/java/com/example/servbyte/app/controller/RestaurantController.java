package com.example.servbyte.app.controller;

import com.example.servbyte.app.model.Meal;
import com.example.servbyte.app.model.ServiceProvider;
import com.example.servbyte.app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping(path = "/meals/{id}")
    public Optional<Meal> getMeals(@PathVariable(name = "id") final Long id){
        return restaurantService.getMealById(id);
    }

    @GetMapping("/city/{id}")
    public List<ServiceProvider> searchRestaurantByCityId(@PathVariable(name = "id") final Long id){
        return restaurantService.getRestaurantsByCityId(id);
    }

    @GetMapping("/{id}")
    public Optional<ServiceProvider> selectRestaurantById(@PathVariable(name = "id") final Long id){
        return restaurantService.getRestaurantById(id);
    }

}
