package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class Course {
    @SerializedName("distance")
    private String distance;
    @SerializedName("distance_unit")
    private String distance_unit;
    @SerializedName("departure_city")
    private String departure_city;
    @SerializedName("arrival_city")
    private  String arrival_city;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDistance_unit() {
        return distance_unit;
    }

    public void setDistance_unit(String distance_unit) {
        this.distance_unit = distance_unit;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public void setDeparture_city(String departure_city) {
        this.departure_city = departure_city;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public void setArrival_city(String arrival_city) {
        this.arrival_city = arrival_city;
    }
}
