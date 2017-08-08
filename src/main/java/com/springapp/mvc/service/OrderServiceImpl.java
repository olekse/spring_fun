package com.springapp.mvc.service;

import com.springapp.mvc.dao.OrderDao;
import com.springapp.mvc.dao.UserProfileDao;
import com.springapp.mvc.model.bp.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderDao dao;


    @Override
    public void saveOrder(Order order) {
        dao.save(order);
    }
}
