package com.example.weatherapp.weather;

import com.example.weatherapp.MainApi;
import com.example.weatherapp.Wind;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("main")
    private MainApi main; // Usa MainApi
    @SerializedName("weather")
    private List<Weather> weather;
    @SerializedName("name")
    private String name;
    @SerializedName("wind")
    private Wind wind;

    public MainApi getMain() { return main; }
    public List<Weather> getWeather() { return weather; }
    public String getName() { return name; }
    public Wind getWind() { return wind; }
}
