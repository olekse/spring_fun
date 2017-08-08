package com.springapp.mvc.dao;

import com.springapp.mvc.model.bp.Order;
import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
@Repository("orderDao")
public class OrderDaoImpl extends  AbstractDao<Integer, Order> implements OrderDao  {
    @Override
    public void save(Order order) {
        persist(order);
    }


}
