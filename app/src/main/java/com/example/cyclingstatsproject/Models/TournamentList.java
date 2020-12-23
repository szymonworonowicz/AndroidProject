package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TournamentList {
    @SerializedName("stages")
    private LinkedList<Tournament> tournaments;

    public LinkedList<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(LinkedList<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}
