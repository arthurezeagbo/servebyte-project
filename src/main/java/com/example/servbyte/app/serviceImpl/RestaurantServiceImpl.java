package com.example.servbyte.app.serviceImpl;

import com.example.servbyte.app.model.Meal;
import com.example.servbyte.app.model.ServiceProvider;
import com.example.servbyte.app.repository.MealRepository;
import com.example.servbyte.app.repository.ServiceProviderRepository;
import com.example.servbyte.app.service.MealService;
import com.example.servbyte.app.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService, MealService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private MealRepository mealRepository;

    @Override
    public Optional<ServiceProvider> getRestaurantById(Long resturantId) {
        return serviceProviderRepository.findById(resturantId);
    }

    @Override
    public List<ServiceProvider> getRestaurantsByCityId(Long citiId) {
        //This is going to be expensive. It's better handled at the once at the database level
        // maybe using native query or stored procedure, but I may come back to it.
        return serviceProviderRepository.findAll()
                .stream().filter(c -> c.getCity().getId() == citiId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Meal> getMealById(Long mealId) {
        return mealRepository.findById(mealId);
    }
}
