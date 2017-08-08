package com.springapp.mvc.controller;

import com.springapp.mvc.model.Person;
import com.springapp.mvc.model.client.Client;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */
public class PrivateForm {
    private Client client;
    private Person person;

    public PrivateForm() {
    }

    public PrivateForm(Client client, Person person) {
        this.client = client;
        this.person = person;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
