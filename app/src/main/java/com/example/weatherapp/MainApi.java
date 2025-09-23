package com.example.weatherapp;

public class MainApi {
    private double temp, umidade, pressao;

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
