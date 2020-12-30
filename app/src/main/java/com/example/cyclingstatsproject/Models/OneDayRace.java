package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class OneDayRace {
    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private String description;
    @SerializedName("scheduled")
    private Date scheduled;
    @SerializedName("scheduled_end")
    private Date scheduled_end;
    @SerializedName("departure_city")
    private String departure_city;
    @SerializedName("arrival_city")
    private String arrival_city;
    @SerializedName("distance")
    private String distance;
    @SerializedName("competitors")
    private List<MsRaceCompetitor> competitors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
    }

    public Date getScheduled_end() {
        return scheduled_end;
    }

    public void setScheduled_end(Date scheduled_end) {
        this.scheduled_end = scheduled_end;
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

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public List<MsRaceCompetitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<MsRaceCompetitor> competitors) {
        this.competitors = competitors;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
