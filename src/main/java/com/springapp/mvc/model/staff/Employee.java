package com.springapp.mvc.model.staff;

import com.springapp.mvc.model.CarSalon;
import com.springapp.mvc.model.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */

@Entity
@AttributeOverride(name = "id", column = @Column(name = "EMP_ID"))
public class Employee extends Person{






    private Set<EmployeeType> types;
    private int salary;
    private Date start_date;
    private Date fire_date;

    //private CarSalon managedSalon;
    private CarSalon getWorkplace;

    @ManyToOne(cascade=CascadeType.ALL)
    public CarSalon getGetWorkplace() {
        return getWorkplace;
    }

    public void setGetWorkplace(CarSalon getWorkplace) {
        this.getWorkplace = getWorkplace;
    }

    @ElementCollection
    @Enumerated(EnumType.STRING)
    public Set<EmployeeType> getTypes() {
        return types;
    }

    public void setTypes(EnumSet<EmployeeType> types) {
        this.types = types;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getFire_date() {
        return fire_date;
    }

    public void setFire_date(Date fire_date) {
        this.fire_date = fire_date;
    }

    /*
    public CarSalon getManagedSalon() {
        return managedSalon;
    }

    public void setManagedSalon(CarSalon managedSalon) {
        this.managedSalon = managedSalon;
    }

    */
}
