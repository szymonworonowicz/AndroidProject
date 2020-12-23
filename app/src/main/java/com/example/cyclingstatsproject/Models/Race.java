package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Race {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("scheduled")
    private Date scheduled;
    @SerializedName("scheduled_end")
    private Date scheduled_end;
    @SerializedName("single_event")
    private boolean single_event;
    @SerializedName("tournament")
    private Tournament tournament;
    @SerializedName("course")
    private Course course;
    @SerializedName("stages")
    private List<Stage> stages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getScheduled() {
        return scheduled;
    }

    public void setScheduled(Date scheduled) {
        this.scheduled = scheduled;
    }

    public Date getScheduled_end() {
        return scheduled_end;
    }

    public void setScheduled_end(Date scheduled_end) {
        this.scheduled_end = scheduled_end;
    }

    public boolean isSingle_event() {
        return single_event;
    }

    public void setSingle_event(boolean single_event) {
        this.single_event = single_event;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }
}
