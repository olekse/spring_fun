package com.springapp.mvc.dao;

import com.springapp.mvc.model.User;
import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.QueryImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */

@Repository("testDriveDao")
public class TestDriveDaoImpl extends  AbstractDao<Integer, TestDrive> implements TestDriveDao {
    @Override
    public void save(TestDrive testDrive) {
        persist(testDrive);
    }

    @Override
    public List<TestDrive> findAllTestDrives() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("timeStart"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<TestDrive> testDrives = (List<TestDrive>) criteria.list();


        return testDrives;
    }

    /*

            Date timeStart;
            Date timeFinish;
            Car car;
            Client client;
            Payment payment;
     */

    @Override
    public List<TestDrive> findTestDrivesForClient(Client client) {

        Criteria criteria = getSession().createCriteria(TestDrive.class);

        criteria.add(Restrictions.eq("client", client));

        List<TestDrive> testDrives = (List<TestDrive>) criteria.list();

        /*
        criteria.setFetchMode("car.imageLink", FetchMode.JOIN);
        criteria.setFetchMode("car.carModel", FetchMode.JOIN);
        criteria.setFetchMode("car.carModel.type", FetchMode.JOIN);
*/

        return testDrives;
    }

    @Override
    public Car findCarByTestDrive(TestDrive testDrive) {
        Criteria criteria = getSession().createCriteria(Car.class);

        criteria.add(Restrictions.eq("car", testDrive.getCar()));



        Car car = (Car) criteria.uniqueResult();

        return car;
    }



    @Override
    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        TestDrive testDrive = (TestDrive)crit.uniqueResult();
        delete(testDrive);
    }
}
