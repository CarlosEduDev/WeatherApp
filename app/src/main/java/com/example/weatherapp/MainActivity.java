package com.example.weatherapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Button btnBuscarCidade;
    private EditText nomeCidade;
    private RecyclerView listaInfoCidade;
    private TextView tvTemp;

    private InfoClimaAdapter adapter;
    private List<String> dadosLista = new ArrayList<>();

    private final String API_KEY = "25df25ec8ad5f75a02213a1b324ad0f2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnBuscarCidade = findViewById(R.id.btnBuscarCidade);
        nomeCidade = findViewById(R.id.nomeCidadeText);
        listaInfoCidade = findViewById(R.id.listaInfoCidade);
//        tvTemp = findViewById(R.id.tvTemp);

        // RecyclerView
        listaInfoCidade.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InfoClimaAdapter(dadosLista);
        listaInfoCidade.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);


        btnBuscarCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cidade = nomeCidade.getText().toString();

                if(cidade.isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor preencha o campo do nome da cidade.",Toast.LENGTH_SHORT).show();
                }

                Call<WeatherResponse> call = service.getCurrentWeather(
                        cidade,
                        API_KEY,
                        "metric",
                        "pt_br"
                );
                call.enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                        if (response.isSuccessful()) {
                            WeatherResponse weatherData = response.body();
                            if (weatherData != null && weatherData.getMain() != null) {
                                dadosLista.clear();

                                dadosLista.add("Cidade: " + weatherData.getNome());
                                dadosLista.add("Temperatura: " + weatherData.getMain().getTemp() + "°C");
                                dadosLista.add("Descrição: " + weatherData.getWeather().get(0).getDescription());

                                adapter.notifyDataSetChanged();
                                // Exibe a temperatura na tela
//                                String temp = String.valueOf(weatherData.getMain().getTemp());
//                                tvTemp.setText("Temperatura: " + temp + "°C");
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Dados da API inválidos.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Exibe uma mensagem de erro se a cidade não for encontrada
                            Log.e("API_CALL", "Erro na resposta: " + response.code());
                            Toast.makeText(MainActivity.this, "Cidade não encontrada. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<WeatherResponse> call, Throwable t) {
                        // Exibe uma mensagem de erro em caso de falha na conexão
                        Log.e("API_CALL", "Falha na requisição: " + t.getMessage());
                        Toast.makeText(MainActivity.this, "Falha na conexão. Verifique sua internet.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}