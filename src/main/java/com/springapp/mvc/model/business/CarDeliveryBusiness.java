package com.springapp.mvc.model.business;

import javax.persistence.*;

/**
 * Created by OleksandrSerediuk on 06.06.2017.
 */
@Table
@Entity
public class CarDeliveryBusiness {
    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    int avgDeliveryTime;

    public CarDeliveryBusiness(int avgDeliveryTime) {
        this.avgDeliveryTime = avgDeliveryTime;
    }

    public int getAvgDeliveryTime() {
        return avgDeliveryTime;
    }

    public void setAvgDeliveryTime(int avgDeliveryTime) {
        this.avgDeliveryTime = avgDeliveryTime;
    }
}
