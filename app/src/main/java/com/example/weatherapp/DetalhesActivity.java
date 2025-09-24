package com.example.weatherapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalhesActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detalhes);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvDetalhesCidade = findViewById(R.id.tvDetalhesCidade);
        TextView tvDetalhesUmidade = findViewById(R.id.tvDetalhesUmidade);
        TextView tvDetalhesPressao = findViewById(R.id.tvDetalhesPressao);
        TextView tvDetalhesVento = findViewById(R.id.tvDetalhesVento);
        TextView tvDetalheDescricao = findViewById(R.id.tvDetalheDescricao);
        TextView tvDetalhesTemperatura = findViewById(R.id.tvDetalheTemperatura);

        City cidade = (City) getIntent().getSerializableExtra("city_object");

        if(cidade != null){
            tvDetalhesCidade.setText("Cidade: " + cidade.getNome());
            tvDetalhesPressao.setText("Pressão: " + cidade.getPressao());
            tvDetalheDescricao.setText("Detalhe: " + cidade.getDescricao());
            tvDetalhesVento.setText("velocidade do vento: " + cidade.getVelocVento());
            tvDetalhesUmidade.setText("Umidade: " + cidade.getUmidade());
            tvDetalhesTemperatura.setText("Temperatura: " + cidade.getTemperatura());
        }else{
            System.out.println("Deu erro");
        }

        // Pega os dados que foram passados pelo Intent
//        Bundle extras = getIntent().getExtras();

//        if(extras != null){
//            String cidade = extras.getString("cidade");
//            String umidade = extras.getString("umidade");
//            String pressao = extras.getString("pressao");
//            String vento = extras.getString("vento");
//            String detalhe = extras.getString("detalhe");
//            String temperatura = extras.getString("temperatura");
//
//            tvDetalhesCidade.setText("Cidade: " + cidade);
//            tvDetalhesPressao.setText("Pressão: " + pressao);
//            tvDetalheDescricao.setText("Detalhe: " + detalhe);
//            tvDetalhesVento.setText("velocidade do vento: " + vento);
//            tvDetalhesUmidade.setText("Umidade: " + umidade);
//            tvDetalhesTemperatura.setText("Temperatura: " + temperatura);
//        }
    }
}