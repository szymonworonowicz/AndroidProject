package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StageSummary {
    @SerializedName("stage")
    private Stage stage;
    @SerializedName("course")
    private Course course;
    @SerializedName("competitors")
    private List<Competitor> competitors;
    @SerializedName("results")
    private List<Result> results;

    public Stage getStage() {
        return stage;
    }

    public Course getCourse() {
        return course;
    }

    public List<Competitor> getCompetitors() {
        return competitors;
    }

    public List<Result> getResults() {
        return results;
    }
}
