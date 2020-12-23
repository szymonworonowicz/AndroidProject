package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class Result {
    @SerializedName("time")
    private String time;
    @SerializedName("time_ranking")
    private int time_ranking;
    @SerializedName("sprint")
    private int sprint;
    @SerializedName("sprint_ranking")
    private int sprint_ranking;
    @SerializedName("climber")
    private int climber;
    @SerializedName("climber_ranking")
    private  int climber_ranking;
    @SerializedName("competitor")
    private Competitor competitor;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getTime_ranking() {
        return time_ranking;
    }

    public void setTime_ranking(int time_ranking) {
        this.time_ranking = time_ranking;
    }

    public int getSprint() {
        return sprint;
    }

    public void setSprint(int sprint) {
        this.sprint = sprint;
    }

    public int getSprint_ranking() {
        return sprint_ranking;
    }

    public void setSprint_ranking(int sprint_ranking) {
        this.sprint_ranking = sprint_ranking;
    }

    public int getClimber() {
        return climber;
    }

    public void setClimber(int climber) {
        this.climber = climber;
    }

    public int getClimber_ranking() {
        return climber_ranking;
    }

    public void setClimber_ranking(int climber_ranking) {
        this.climber_ranking = climber_ranking;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }
}
