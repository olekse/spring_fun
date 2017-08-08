package com.springapp.mvc.model.client;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class ClientBankCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    int creditCardNo;
    int validUntilMonth;
    int validUntilYear;
    int cvv;
    Client client;



    public int getCreditCardNo() {
        return creditCardNo;
    }

    public void setCreditCardNo(int creditCardNo) {
        this.creditCardNo = creditCardNo;
    }

    public int getValidUntilMonth() {
        return validUntilMonth;
    }

    public void setValidUntilMonth(int validUntilMonth) {
        this.validUntilMonth = validUntilMonth;
    }

    public int getValidUntilYear() {
        return validUntilYear;
    }

    public void setValidUntilYear(int validUntilYear) {
        this.validUntilYear = validUntilYear;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientBankCard(int id, int creditCardNo, int validUntilMonth, int validUntilYear, int cvv, Client client) {
        this.creditCardNo = creditCardNo;
        this.validUntilMonth = validUntilMonth;
        this.validUntilYear = validUntilYear;
        this.cvv = cvv;
        this.client = client;
        this.id = id;
    }
}
