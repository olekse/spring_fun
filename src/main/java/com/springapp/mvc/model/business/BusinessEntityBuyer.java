package com.springapp.mvc.model.business;

import com.springapp.mvc.model.client.UserInfoContainer;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */

@Table
@Entity
public class BusinessEntityBuyer extends Business {
    public BusinessEntityBuyer(String nameOfTheBusiness, String adress, String postCode, int primaryPhoneNumber, int secondaryPhoneNumber,
                               String website, BusinessType businessType) {
        super(nameOfTheBusiness, adress, postCode, primaryPhoneNumber, secondaryPhoneNumber, website, businessType);
    }
}
