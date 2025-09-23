package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    private MainApi main;
    private List<Weather> weather;

    @SerializedName("name")
    private String nome;

    public MainApi getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getNome() {
        return nome;
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
}
