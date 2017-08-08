package com.springapp.mvc.dao;

import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
@Repository("carDao")
public class CarDaoImpl extends AbstractDao<Integer, Car> implements CarDao {
    @Override
    public List<Car> findAllCars() {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("recomendedPrice"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Car> cars = (List<Car>) criteria.list();


        for(Car car : cars){
            //Hibernate.initialize(client.getBankCards());
        }
        return cars;
    }

    @Override
    public Car findCarById(int id) {
        Car car = getByKey(id);
        if(car != null){
            //Hibernate.initialize(client.getBankCards());
        }
        return car;
    }


}
