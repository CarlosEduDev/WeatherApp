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

    // Getters para a MainActivity e DetalhesActivity
    public String getNome() { return nome; }
    public String getTemperatura() { return temperatura; }
    public String getDescricao() { return descricao; }
    public String getUmidade() { return umidade; }
    public String getPressao() { return pressao; }
    public String getVelocVento() { return velocVento; }

    // Setters (boa prática, mas não obrigatórios aqui)
    public void setNome(String nome) { this.nome = nome; }
    public void setTemperatura(String temperatura) { this.temperatura = temperatura; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setUmidade(String umidade) { this.umidade = umidade; }
    public void setPressao(String pressao) { this.pressao = pressao; }
    public void setVelocVento(String velocVento) { this.velocVento = velocVento; }
}