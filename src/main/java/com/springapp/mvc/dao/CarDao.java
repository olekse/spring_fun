package com.springapp.mvc.dao;

import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface CarDao {
    List<Car> findAllCars();
    Car findCarById(int id);
}
