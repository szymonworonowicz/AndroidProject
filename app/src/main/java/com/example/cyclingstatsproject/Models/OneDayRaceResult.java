package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class OneDayRaceResult {
    @SerializedName("stage")
    private OneDayRace stage;

    public OneDayRace getStage() {
        return stage;
    }

    public void setStage(OneDayRace stage) {
        this.stage = stage;
    }
}
