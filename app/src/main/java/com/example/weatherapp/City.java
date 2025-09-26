package com.example.weatherapp;

import java.io.Serializable;

public class City implements Serializable {
    // Dados para a primeira tela
    private String nome, temperatura, descricao;
    // Dados para a segunda tela
    private String umidade, pressao, velocVento;

    public City(String nome, String temperatura, String descricao, String umidade, String pressao, String velocVento) {
        this.nome = nome;
        this.temperatura = temperatura;
        this.descricao = descricao;
        this.umidade = umidade;
        this.pressao = pressao;
        this.velocVento = velocVento;
    }

    // Getters pra usar na MainActivity e DetalhesActivity
    public String getNome() { return nome; }
    public String getTemperatura() { return temperatura; }
    public String getDescricao() { return descricao; }
    public String getUmidade() { return umidade; }
    public String getPressao() { return pressao; }
    public String getVelocVento() { return velocVento; }
}