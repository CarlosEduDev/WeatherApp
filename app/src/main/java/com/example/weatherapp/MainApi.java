package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class MainApi {
    @SerializedName("temp")
    private double temperatura; // Mapeia "temp" do JSON
    @SerializedName("pressure")
    private double pressao; // Mapeia "pressure" do JSON
    @SerializedName("humidity")
    private double umidade; // Mapeia "humidity" do JSON

    public double getTemperatura() { return temperatura; }
    public double getPressao() { return pressao; }
    public double getUmidade() { return umidade; }
}
