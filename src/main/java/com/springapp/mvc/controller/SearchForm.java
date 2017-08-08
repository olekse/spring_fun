package com.springapp.mvc.controller;

/**
 * Created by OleksandrSerediuk on 14.06.2017.
 */
public class SearchForm {

    private String color;
    private String type;
    private String mileage_min;
    private String mileage_max;

    public String getMileage_min() {
        return mileage_min;
    }

    public void setMileage_min(String mileage_min) {
        this.mileage_min = mileage_min;
    }

    public String getMileage_max() {
        return mileage_max;
    }

    public void setMileage_max(String mileage_max) {
        this.mileage_max = mileage_max;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
