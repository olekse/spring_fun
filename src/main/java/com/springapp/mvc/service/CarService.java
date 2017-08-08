package com.springapp.mvc.service;

import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface CarService {
    List<Car> findAllCars();
    Car findById(int id);
}
