package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamProfile {
    @SerializedName("team")
    private  Team team;
    @SerializedName("competitors")
    private List<Competitor> competitors;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public void setCompetitors(List<Competitor> competitors) {
        this.competitors = competitors;
    }
}
