package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class RaceResult {
    @SerializedName("time")
    private String time;
    @SerializedName("time_ranking")
    private int time_ranking;
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


}
