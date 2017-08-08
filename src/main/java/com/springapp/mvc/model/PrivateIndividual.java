package com.springapp.mvc.model;

import com.springapp.mvc.model.client.UserInfoContainer;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class PrivateIndividual extends Person{

    private int drivingLicenseNo;
    private Date drivingLicenseDate;

    public PrivateIndividual(int drivingLicenseNo, Date drivingLicenseDate) {
        this.drivingLicenseNo = drivingLicenseNo;
        this.drivingLicenseDate = drivingLicenseDate;
    }

    public PrivateIndividual(){

    }


    private UserInfoContainer userInfoContainer;

    @OneToOne
    public UserInfoContainer getUserInfoContainer() {
        return userInfoContainer;
    }

    public void setUserInfoContainer(UserInfoContainer userInfoContainer) {
        this.userInfoContainer = userInfoContainer;
    }

    public int getDrivingLicenseNo() {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo(int drivingLicenseNo) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public Date getDrivingLicenseDate() {
        return drivingLicenseDate;
    }

    public void setDrivingLicenseDate(Date drivingLicenseDate) {
        this.drivingLicenseDate = drivingLicenseDate;
    }
}
