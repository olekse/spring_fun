package com.springapp.mvc.service;

import com.springapp.mvc.model.car.Model;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface ModelService {
    Model findById(int id);
}
