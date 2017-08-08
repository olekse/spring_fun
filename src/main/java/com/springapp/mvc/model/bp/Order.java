package com.springapp.mvc.model.bp;

import com.springapp.mvc.model.business.InsuranceCompany;
import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.client.Client;
import com.springapp.mvc.model.staff.Employee;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */

@Table
@Entity(name = "car_orders")
public class Order  {

    private int id;

    public Order() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date orderDate;
    private Date lastOrder;
    private Car car;
    private Client client;
    private Payment payment;
    private Employee salesman;
    private InsuranceCompany insuranceCompany;

    public Order(Date orderDate, Date lastOrder, Car car, Client client, Payment payment,Employee salesman, InsuranceCompany insuranceCompany) {
        super();

        this.orderDate = orderDate;
        this.lastOrder = lastOrder;
        this.car = car;
        this.client = client;
        this.payment = payment;
        this.salesman = salesman;
        this.insuranceCompany = insuranceCompany;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Date lastOrder) {
        this.lastOrder = lastOrder;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @ManyToOne
    public Client getClient() {
        return client;
    }

    @ManyToOne
    public Employee getSalesman() {
        return salesman;
    }

    public void setSalesman(Employee salesman) {
        this.salesman = salesman;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


    @ManyToOne(fetch = FetchType.LAZY)
    public InsuranceCompany getInsuranceCompany() {
        return insuranceCompany;
    }

    public void setInsuranceCompany(InsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
}
