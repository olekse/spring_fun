package com.springapp.mvc.dao;

import com.springapp.mvc.model.Person;
import com.springapp.mvc.model.business.Business;
import org.springframework.stereotype.Repository;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */


@Repository("personDao")
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {
    @Override
    public void save(Person person) {
        persist(person);
    }
}
