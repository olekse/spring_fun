package com.springapp.mvc.service;

import com.springapp.mvc.dao.ModelDao;
import com.springapp.mvc.model.car.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
@Service("modelService")
@Transactional
public class ModelServiceImpl implements ModelService {

    @Autowired
    private ModelDao dao;

    @Override
    public Model findById(int id) {
        return dao.findById(id);
    }
}
