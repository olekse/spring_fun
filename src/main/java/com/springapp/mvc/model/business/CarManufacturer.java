package com.springapp.mvc.model.business;

import com.springapp.mvc.model.car.Model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class CarManufacturer {

    private int id;

    public CarManufacturer(){

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


    private Set<Model> carModels;

    @OneToMany(cascade = CascadeType.ALL)
    public Set<Model> getCarModels() {
        return carModels;
    }

    public void setCarModels(Set<Model> carModels) {
        this.carModels = carModels;
    }

    public CarManufacturer(int id, Set<Model> carModels, String brandName) {
        this.id = id;
        this.carModels = carModels;
        this.brandName = brandName;
    }

    private String brandName;

    public CarManufacturer(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
