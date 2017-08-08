package com.springapp.mvc.dao;

import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface TestDriveDao {
    void save(TestDrive testDrive);
    List<TestDrive> findAllTestDrives();
    List<TestDrive> findTestDrivesForClient(Client client);
    public Car findCarByTestDrive(TestDrive testDrive);
    void deleteById(int id);
}
