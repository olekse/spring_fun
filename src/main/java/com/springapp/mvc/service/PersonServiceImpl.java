package com.springapp.mvc.service;

import com.springapp.mvc.dao.PersonDao;
import com.springapp.mvc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonDao dao;

    @Override
    public void save(Person person) {
        dao.save(person);
    }
}
