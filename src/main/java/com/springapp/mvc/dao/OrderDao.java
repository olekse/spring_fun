package com.springapp.mvc.dao;

import com.springapp.mvc.model.bp.Order;
import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.car.Model;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface OrderDao {
    void save(Order user);

}
