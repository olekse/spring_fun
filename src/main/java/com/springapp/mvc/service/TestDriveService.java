package com.springapp.mvc.service;

import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.client.Client;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */
public interface TestDriveService {
    void saveTestDrive(TestDrive order);
    List<TestDrive> findAllTestDrives();
    List<TestDrive> findTestDrivesOfAClient(Client client);
    void deleteById(int id);
}
