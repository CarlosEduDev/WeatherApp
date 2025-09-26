package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("id")
    private int id;
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

    public int getId() { return id; }
    public String getMain() { return main; }
    public String getDescription() { return description; }
    public String getIcon() { return icon; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setMain(String main) { this.main = main; }
    public void setDescription(String description) { this.description = description; }
    public void setIcon(String icon) { this.icon = icon; }
}
