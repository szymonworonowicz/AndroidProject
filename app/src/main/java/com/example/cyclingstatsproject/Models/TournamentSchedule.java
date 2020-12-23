package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TournamentSchedule {
    @SerializedName("races")
    private List<Race> races;

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
