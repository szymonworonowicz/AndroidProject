package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Race {
    @SerializedName("id")
    private String id;
    @SerializedName("description")
    private String name;
    @SerializedName("scheduled")
    private Date scheduled;
    @SerializedName("scheduled_end")
    private Date scheduled_end;
    @SerializedName("single_event")
    private boolean single_event;
    @SerializedName("type")
    private String type;
    @SerializedName("stages")
    private List<Race> stages;

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

    public List<Race> getStages() {
        return stages;
    }

    public void setStages(List<Race> stages) {
        this.stages = stages;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
