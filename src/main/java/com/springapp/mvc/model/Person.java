package com.springapp.mvc.model;

import com.springapp.mvc.model.client.Gender;
import com.springapp.mvc.model.client.Passport;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person{

    protected int id;

    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Date dateOfBirth;

    protected Gender gender;
    protected Passport passport;


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    @Enumerated(EnumType.ORDINAL)
    public Gender getGender() {
        return gender;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Passport getPassport() {
        return passport;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Person(){}

    public Person(int id, String firstName, String middleName, String lastName, Date dateOfBirth, Gender gender, Passport passport) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.passport = passport;
    }
}
