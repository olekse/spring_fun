package com.springapp.mvc.model.car;

import com.springapp.mvc.model.business.BatteryType;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class ElectricMotorSystem {

    private Model model;

    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    private double powerKw;
    private double chargeTime;
    private BatteryType batteryType;

    public ElectricMotorSystem(double powerKw, double chargeTime, BatteryType batteryType) {
        this.powerKw = powerKw;
        this.chargeTime = chargeTime;
        this.batteryType = batteryType;
    }

    public double getPowerKw() {
        return powerKw;
    }

    public void setPowerKw(double powerKw) {
        this.powerKw = powerKw;
    }

    public double getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(double chargeTime) {
        this.chargeTime = chargeTime;
    }

    @Enumerated(EnumType.ORDINAL)
    public BatteryType getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(BatteryType batteryType) {
        this.batteryType = batteryType;
    }
}
