package com.springapp.mvc.controller;

import com.springapp.mvc.model.business.Business;
import com.springapp.mvc.model.client.Client;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */
public class BusinessForm {

    private Client client;
    private Business business;

    public BusinessForm(Client userInfo, Business businessInfo) {
        this.client = userInfo;
        this.business = businessInfo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public BusinessForm() {
    }
}
