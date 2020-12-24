package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Rider {
    @SerializedName("competitor")
    private CompetitorProfile competitor;
    @SerializedName("teams")
    private List<Team> teams;

    public CompetitorProfile getCompetitor() {
        return competitor;
    }

    public void setCompetitor(CompetitorProfile competitor) {
        this.competitor = competitor;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
