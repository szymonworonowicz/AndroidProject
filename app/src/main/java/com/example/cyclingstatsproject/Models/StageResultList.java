package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StageResultList {
    @SerializedName("results")
    private List<StageResult> results;

    public List<StageResult> getResults() {
        return results;
    }

    public void setResults(List<StageResult> results) {
        this.results = results;
    }
}
