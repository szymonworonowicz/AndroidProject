package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Stage {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("scheduled")
    private Date scheduled;
    @SerializedName("scheduled_end")
    private Date scheduled_end;
    @SerializedName("course")
    private List<Course> courses;

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

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
