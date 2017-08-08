package com.springapp.mvc.model.bp;


import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Receipt{

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String text;
    private Payment payment;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @OneToOne(cascade=CascadeType.ALL)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Receipt(String text, Payment payment) {
        super();
        this.text = text;
        this.payment = payment;
    }
}
