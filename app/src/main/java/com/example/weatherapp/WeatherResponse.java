package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("main")
    private MainApi main; // Usa MainApi
    @SerializedName("weather")
    private List<Weather> weather;
    @SerializedName("name")
    private String name; // Campo 'name' do JSON
    @SerializedName("wind")
    private Wind wind;

    public MainApi getMain() { return main; }
    public List<Weather> getWeather() { return weather; }
    public String getName() { return name; } // Getter que retorna o nome da cidade
    public Wind getWind() { return wind; }

    // Setters (apenas para referência)
    public void setMain(MainApi main) { this.main = main; }
    public void setWeather(List<Weather> weather) { this.weather = weather; }
    public void setName(String name) { this.name = name; }
    public void setWind(Wind wind) { this.wind = wind; }
}
