package com.example.weatherapp;

import java.io.Serializable;

public class City implements Serializable {
    private String nome, temperatura, descricao;
    private String umidade, pressao, velocVento; // pra segunda tela

    public City(String nome, String temperatura, String descricao, String umidade, String pressao, String velocVento) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.descricao = descricao;
        this.umidade = umidade;
        this.pressao = pressao;
        this.velocVento = velocVento;
    }

    public String getNome() {
        return nome;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUmidade() {
        return umidade;
    }

    public String getPressao() {
        return pressao;
    }

    public String getVelocVento() {
        return velocVento;
    }
}
