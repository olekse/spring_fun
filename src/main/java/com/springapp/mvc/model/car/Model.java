package com.springapp.mvc.model.car;

import com.springapp.mvc.model.business.CarManufacturer;
import com.sun.org.apache.xpath.internal.operations.Mod;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class Model{

    private int id;
    private int yearOfRelease;
    private int enginePowerHP;
    private String modelName;
    private boolean isOpenRoof;
    private String type;
    private CarManufacturer manufacturer;

    private ElectricMotorSystem ems;

    private InternalCombustionSystem ics;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public InternalCombustionSystem getIcs() {
        return ics;
    }

    public void setIcs(InternalCombustionSystem ics) {
        this.ics = ics;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public ElectricMotorSystem getEms() {
        return ems;
    }

    public void setEms(ElectricMotorSystem ems) {
        this.ems = ems;
    }

    public Model(int id,
                 int yearOfRelease,
                 int enginePowerHP,
                 String modelName,
                 boolean isOpenRoof,
                 String type,
                 double powerKw,
                 double chargeTime,
                 CarManufacturer manufacturer
                 ) {

        super();

        this.id = id;
        this.yearOfRelease = yearOfRelease;
        this.enginePowerHP = enginePowerHP;
        this.modelName = modelName;
        this.isOpenRoof = isOpenRoof;
        this.type = type;
        this.manufacturer = manufacturer;
    }


    public Model(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getEnginePowerHP() {
        return enginePowerHP;
    }

    public void setEnginePowerHP(int enginePowerHP) {
        this.enginePowerHP = enginePowerHP;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public boolean isOpenRoof() {
        return isOpenRoof;
    }

    public void setOpenRoof(boolean openRoof) {
        isOpenRoof = openRoof;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public CarManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(CarManufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}
