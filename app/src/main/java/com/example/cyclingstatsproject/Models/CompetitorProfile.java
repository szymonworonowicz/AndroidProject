package com.example.cyclingstatsproject.Models;

import com.google.gson.annotations.SerializedName;

public class CompetitorProfile {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("country_code")
    private String country_code;
    @SerializedName("nationality")
    private String nationality;

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

    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
