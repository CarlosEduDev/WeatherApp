package com.example.weatherapp.activities;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.weatherapp.City;
import com.example.weatherapp.R;

public class DetalhesActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes);

        // 1. Encontrar os TextViews no layout
        TextView tvDetalhesCidade = findViewById(R.id.tvDetalhesCidade);
        TextView tvDetalhesUmidade = findViewById(R.id.tvDetalhesUmidade);
        TextView tvDetalhesPressao = findViewById(R.id.tvDetalhesPressao);
        TextView tvDetalhesVento = findViewById(R.id.tvDetalhesVento);
        TextView tvDetalheDescricao = findViewById(R.id.tvDetalheDescricao);
        TextView tvDetalhesTemperatura = findViewById(R.id.tvDetalheTemperatura);

        Button btnVoltar = findViewById(R.id.btnVoltar);

        // 2. Receber o objeto City inteiro
        City cidade = (City) getIntent().getSerializableExtra("city_object");

        // 3. Verificar o objeto e preencher a tela
        if(cidade != null){
            tvDetalhesCidade.setText("Cidade: " + cidade.getNome());
            tvDetalhesPressao.setText("Pressão: " + cidade.getPressao());
            tvDetalheDescricao.setText("Detalhe: " + cidade.getDescricao());
            tvDetalhesVento.setText("Velocidade do Vento: " + cidade.getVelocVento());
            tvDetalhesUmidade.setText("Umidade: " + cidade.getUmidade());
            tvDetalhesTemperatura.setText("Temperatura: " + cidade.getTemperatura());
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}