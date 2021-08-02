package com.example.servbyte.app.service;


import com.example.servbyte.app.model.Meal;

import java.util.Optional;

public interface MealService {

    Optional<Meal> getMealById(Long mealId);

}
