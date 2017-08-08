package com.springapp.mvc.service;

import com.springapp.mvc.dao.BusinessDao;
import com.springapp.mvc.dao.PersonDao;
import com.springapp.mvc.model.Person;
import com.springapp.mvc.model.business.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */

@Service("businessService")
@Transactional
class BusinessServiceImpl implements BusinessService {

    @Autowired
    BusinessDao dao;


    @Override
    public void save(Business business) {
        dao.save(business);
    }
}
