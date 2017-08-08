package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.car.Model;
import com.springapp.mvc.model.client.Client;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */

@Repository("modelDao")
public class ModelDaoImpl extends AbstractDao<Integer, Model> implements ModelDao  {
    @Override
    public Model findById(int id) {

        Model model = getByKey(id);

        return model;
    }
}
