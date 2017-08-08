package com.springapp.mvc.model;

import com.springapp.mvc.model.car.Car;
import com.springapp.mvc.model.staff.Employee;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class CarSalon {


    int id;
    Date timeStart;
    Date timeFinish;
    Set<Car> car;
    Set<Employee> employee;

    public CarSalon(int id, Date timeStart, Date timeFinish, Set<Car> car, Set<Employee> employee) {
        super();

        this.id = id;
        this.timeStart = timeStart;
        this.timeFinish = timeFinish;
        this.car = car;
        this.employee = employee;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeFinish() {
        return timeFinish;
    }

    public void setTimeFinish(Date timeFinish) {
        this.timeFinish = timeFinish;
    }

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Car> getCars() {
        return car;
    }

    public void setCars(Set<Car> car) {
        this.car = car;
    }


    @OneToMany(cascade = CascadeType.ALL)
    public Set<Employee> getEmployees() {
        return employee;
    }

    public void setEmployees(Set<Employee> employee) {
        this.employee = employee;
    }
}
