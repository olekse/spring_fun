package com.springapp.mvc.dao;

import com.springapp.mvc.model.business.Business;
import com.springapp.mvc.model.car.Car;
import org.springframework.stereotype.Repository;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */

@Repository("businessDao")
public class BusinessDaoImpl extends AbstractDao<Integer, Business> implements BusinessDao {
    @Override
    public void save(Business business) {
        persist(business);
    }
}
