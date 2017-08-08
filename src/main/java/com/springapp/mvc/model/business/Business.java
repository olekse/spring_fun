package com.springapp.mvc.model.business;


import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */

@Table
@Entity(name = "BUSINESS")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Business {


    public Business(String nameOfTheBusiness, String adress, String postCode, int primaryPhoneNumber, int secondaryPhoneNumber, String website, BusinessType businessType) {
        this.nameOfTheBusiness = nameOfTheBusiness;
        this.adress = adress;
        this.postCode = postCode;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.website = website;
        this.businessType = businessType;
    }

    public String getNameOfTheBusiness() {
        return nameOfTheBusiness;
    }

    public void setNameOfTheBusiness(String nameOfTheBusiness) {
        this.nameOfTheBusiness = nameOfTheBusiness;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public int getPrimaryPhoneNumber() {
        return primaryPhoneNumber;
    }

    public void setPrimaryPhoneNumber(int primaryPhoneNumber) {
        this.primaryPhoneNumber = primaryPhoneNumber;
    }

    public int getSecondaryPhoneNumber() {
        return secondaryPhoneNumber;
    }

    public void setSecondaryPhoneNumber(int secondaryPhoneNumber) {
        this.secondaryPhoneNumber = secondaryPhoneNumber;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Enumerated(EnumType.ORDINAL)
    public BusinessType getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessType businessType) {
        this.businessType = businessType;
    }

    protected int id;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Business() {
    }

    protected String nameOfTheBusiness;
    protected String adress;
    protected String postCode;
    protected int primaryPhoneNumber;
    protected int secondaryPhoneNumber;
    protected String website;
    protected BusinessType businessType;

}
