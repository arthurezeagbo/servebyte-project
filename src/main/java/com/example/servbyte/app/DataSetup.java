package com.example.servbyte.app;

import com.example.servbyte.app.model.City;
import com.example.servbyte.app.model.Meal;
import com.example.servbyte.app.model.ServiceProvider;
import com.example.servbyte.app.repository.CityRepository;
import com.example.servbyte.app.repository.MealRepository;
import com.example.servbyte.app.repository.ServiceProviderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Slf4j
public class DataSetup implements CommandLineRunner {

    @Autowired
    MealRepository mealRepository;
    @Autowired
    CityRepository cityRepository;
    @Autowired
    ServiceProviderRepository serviceProviderRepository;


    @Override
    public void run(String... args) throws Exception {

        log.info("SETTING UP DATA");

        List<City> cityList =  List.of(new City("Abuja"),new City("Lagos"),new City("Ibadan")
                ,new City("Uyo"),new City("Port Harcourt"),new City("Enugu"),new City("Asaba")
                ,new City("Kano"),new City("Umuahia"),new City("Onitsha")
                ,new City("Aba"),new City("Owerri"));

        City city1 = new City("Abuja");

        List<City> savedCities = cityRepository.saveAll(cityList);

        List<ServiceProvider> serviceProviderList = List.of(
                new ServiceProvider("KFC","kfc@gmail.com",null,"08000000001"));

        List<ServiceProvider> serviceProviders = new ArrayList<>();
        List<ServiceProvider> savedServiceProvider = new ArrayList<>();

        savedCities.stream().forEach(city -> {
            serviceProviderList.stream().forEach(serviceProvider -> {
                serviceProvider.setCity(city);
                serviceProviders.add(serviceProvider);
            });
            int md = 8;
            List<ServiceProvider> mn = new ArrayList<>();
            mn = serviceProviderRepository.saveAll(serviceProviders);
            savedServiceProvider.addAll(mn);
        });

        List<Meal> mealsList = List.of(new Meal(null, 2500, LocalTime.of(0, 20),"Noodle and egg"));

        List<Meal> mealArrayList = new ArrayList<>();

        savedServiceProvider.stream().forEach(serviceProvider -> {
            mealsList.stream().forEach(meal -> {
                meal.setServiceProvider(serviceProvider);
                mealArrayList.add(meal);
                mealRepository.save(meal);
            });

        });

        log.info("DONE WITH DATA SETUP!");

    }
}

