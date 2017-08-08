package com.springapp.mvc.dao;

import com.springapp.mvc.model.car.Model;
import com.springapp.mvc.model.client.Client;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface ModelDao {
    Model findById(int id);
}
