package com.example.weatherapp;

import com.google.gson.annotations.SerializedName;

public class MainApi {

    @SerializedName("temp")
    private double temp;

    @SerializedName("pressure")
    private double pressao;

    @SerializedName("humidity")
    private double umidade;

    public double getTemp() {
        return temp;
    }

    public double getUmidade() {
        return umidade;
    }

    public double getPressao() {
        return pressao;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }
}
