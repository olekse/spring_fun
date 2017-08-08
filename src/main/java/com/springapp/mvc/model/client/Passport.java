package com.springapp.mvc.model.client;

import com.springapp.mvc.model.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Passport {


    private Person person;
    private int id;
    private String no;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setPerson(Person person){
        this.person = person;
    }

    @OneToOne(fetch = FetchType.LAZY, targetEntity = Person.class)
    public Person getPerson(){
        return this.person;
    }


    private Date validUntil;

    @Column(unique = true, nullable = false)
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Column(nullable = false)
    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public Passport(String no, Date validUntil, Person person) {
        this.no = no;
        this.validUntil = validUntil;
        this.person = person;
    }
}
