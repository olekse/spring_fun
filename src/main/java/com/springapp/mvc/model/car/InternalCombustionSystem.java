package com.springapp.mvc.model.car;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class InternalCombustionSystem {
    private double powerHP;
    private int maxRevPerMinute;
    private FuelType fuelType;

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

    private Model model;

    public InternalCombustionSystem(double powerHP, int maxRevPerMinute, FuelType fuelType) {
        this.powerHP = powerHP;
        this.maxRevPerMinute = maxRevPerMinute;
        this.fuelType = fuelType;
    }

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public double getPowerHP() {
        return powerHP;
    }

    public void setPowerHP(double powerHP) {
        this.powerHP = powerHP;
    }

    public int getMaxRevPerMinute() {
        return maxRevPerMinute;
    }

    public void setMaxRevPerMinute(int maxRevPerMinute) {
        this.maxRevPerMinute = maxRevPerMinute;
    }

    @Enumerated(EnumType.ORDINAL)
    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}
