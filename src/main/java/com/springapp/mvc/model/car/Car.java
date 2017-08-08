package com.springapp.mvc.model.car;

import com.springapp.mvc.model.CarSalon;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Car {
    private int recomendedPrice;
    private Integer milage;
    private int warrantyTerm;
    private CarSalon carSalon;
    private Model carModel;
    private String imageLink;
    private String color;
    private int id;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public Car(){

    }

    @ManyToOne
    public Model getCarModel() {
        return carModel;
    }

    public void setCarModel(Model carModel) {
        this.carModel = carModel;
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




    public Car(int recomendedPrice, int milage, int warrantyTerm, CarSalon carSalon) {
        this.recomendedPrice = recomendedPrice;
        this.milage = milage;
        this.warrantyTerm = warrantyTerm;
        this.carSalon = carSalon;
    }

    public int getRecomendedPrice() {
        return recomendedPrice;
    }

    public void setRecomendedPrice(int recomendedPrice) {
        this.recomendedPrice = recomendedPrice;
    }

    public Integer getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public int getWarrantyTerm() {
        return warrantyTerm;
    }

    public void setWarrantyTerm(int warrantyTerm) {
        this.warrantyTerm = warrantyTerm;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public CarSalon getCarSalon() {
        return carSalon;
    }

    public void setCarSalon(CarSalon carSalon) {
        this.carSalon = carSalon;
    }
}
