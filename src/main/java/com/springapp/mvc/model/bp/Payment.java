package com.springapp.mvc.model.bp;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Payment   {
    private int totalPrice;
    private Date date ;
    private String type;
    private int creditCardNumber;
    private int expMonth;
    private int expYear;
    private int CCV;
    private Receipt receipt;

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Payment(int totalPrice, Date date, String type, int creditCardNumber, int expMonth, int expYear, int CCV, Receipt receipt, Order order) {
        super();

        this.totalPrice = totalPrice;
        this.date = date;
        this.type = type;
        this.creditCardNumber = creditCardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
        this.CCV = CCV;
        this.receipt = receipt;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public int getCCV() {
        return CCV;
    }

    public void setCCV(int CCV) {
        this.CCV = CCV;
    }

    @OneToOne(cascade=CascadeType.ALL)
    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

}
