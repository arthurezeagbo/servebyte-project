package com.example.servbyte.app.service;

import com.example.servbyte.app.model.ServiceProvider;

import java.util.List;
import java.util.Optional;

public interface RestaurantService extends MealService {

    Optional<ServiceProvider> getRestaurantById(Long resturantId);

    List<ServiceProvider> getRestaurantsByCityId(Long citiId);

}
