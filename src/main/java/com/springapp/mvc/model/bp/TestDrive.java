package com.springapp.mvc.model.bp;

import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class TestDrive {
    int id;
    Date timeStart;
    Date timeFinish;
    Car car;
    Client client;
    Payment payment;

    @OneToOne(cascade=CascadeType.ALL)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public TestDrive(int id, Date timeStart, Date timeFinish, Car car, Client client) {
        super();

        this.id = id;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.car = car;
        this.client = client;
    }

    public TestDrive(){}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @NotNull
    public Date getTimeStart() {
        return timeStart;
    }


    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }


    @NotNull
    public Date getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(Date timeFinish) {
        this.timeFinish = timeFinish;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
