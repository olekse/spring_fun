package com.springapp.mvc.model.client;

import com.springapp.mvc.model.PrivateIndividual;
import com.springapp.mvc.model.business.BusinessEntityBuyer;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 07.06.2017.
 */
@Table
@Entity
public class UserInfoContainer {

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    public BusinessEntityBuyer getBusinessEntityBuyer() {
        return businessEntityBuyer;
    }

    public void setBusinessEntityBuyer(BusinessEntityBuyer businessEntityBuyer) {
        this.businessEntityBuyer = businessEntityBuyer;
    }


    @OneToOne
    public PrivateIndividual getPrivateIndividual() {
        return privateIndividual;
    }

    public void setPrivateIndividual(PrivateIndividual privateIndividual) {
        this.privateIndividual = privateIndividual;
    }


    private PrivateIndividual privateIndividual;
    private BusinessEntityBuyer businessEntityBuyer;

    private Boolean isBusiness;

    public UserInfoContainer(PrivateIndividual privateIndividual, BusinessEntityBuyer businessEntityBuyer, Boolean isBusiness) {
        this.privateIndividual = privateIndividual;
        this.businessEntityBuyer = businessEntityBuyer;
        this.isBusiness = isBusiness;
    }
}
