package com.springapp.mvc.service;

import com.springapp.mvc.dao.CarDao;
import com.springapp.mvc.dao.ClientDao;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;



    @Override
    public List<Car> findAllCars() {
        return carDao.findAllCars();
    }

    @Override
    public Car findById(int id) {
        return carDao.findCarById(id);
    }


}
