package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class StageResult {
    @SerializedName("time")
    private String time;
    @SerializedName("time_ranking")
    private int time_ranking;
    @SerializedName("competitor")
    private Competitor competitor;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Competitor getCompetitor() {
        return competitor;
    }

    public void setCompetitor(Competitor competitor) {
        this.competitor = competitor;
    }


    public int getTime_ranking() {
        return time_ranking;
    }

    public void setTime_ranking(int time_ranking) {
        this.time_ranking = time_ranking;
    }
}
