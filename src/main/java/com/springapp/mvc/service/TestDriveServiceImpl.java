package com.springapp.mvc.service;

import com.springapp.mvc.dao.OrderDao;
import com.springapp.mvc.dao.TestDriveDao;
import com.springapp.mvc.model.bp.TestDrive;
import com.springapp.mvc.model.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by OleksandrSerediuk on 09.06.2017.
 */

@Service("testDriveService")
@Transactional
public class TestDriveServiceImpl implements TestDriveService {

    @Autowired
    TestDriveDao dao;


    @Override
    public void saveTestDrive(TestDrive testDrive) {
        dao.save(testDrive);
    }

    @Override
    public List<TestDrive> findAllTestDrives() {
        return dao.findAllTestDrives();
    }

    @Override
    public List<TestDrive> findTestDrivesOfAClient(Client client) {
        return dao.findTestDrivesForClient(client);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
