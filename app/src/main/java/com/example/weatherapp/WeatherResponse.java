package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    @SerializedName("main")
    private MainApi main;

    @SerializedName("weather")
    private List<Weather> weather;

    @SerializedName("name")
    private String nome;

    @SerializedName("wind")
    private Wind wind;

    public MainApi getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getNome() {
        return nome;
    }

    public Wind getWind() {
        return wind;
    }

    public void setMain(MainApi main) {
        this.main = main;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
