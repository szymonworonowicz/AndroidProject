package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("id")
    private  String id;
    @SerializedName("name")
    private String name;

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
}
