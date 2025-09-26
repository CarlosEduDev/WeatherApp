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

        // 1. Encontrar os TextViews no layout
        TextView tvDetalhesCidade = findViewById(R.id.tvDetalhesCidade);
        TextView tvDetalhesUmidade = findViewById(R.id.tvDetalhesUmidade);
        TextView tvDetalhesPressao = findViewById(R.id.tvDetalhesPressao);
        TextView tvDetalhesVento = findViewById(R.id.tvDetalhesVento);
        TextView tvDetalheDescricao = findViewById(R.id.tvDetalheDescricao);
        TextView tvDetalhesTemperatura = findViewById(R.id.tvDetalheTemperatura);

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
        } else {
            // Em caso de erro, exiba uma mensagem no Logcat
            System.err.println("ERRO: Objeto City não encontrado no Intent. Verifique a MainActivity.");
        }
    }
}