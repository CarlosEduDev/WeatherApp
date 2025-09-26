package com.example.weatherapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.City;
import com.example.weatherapp.InfoClimaAdapter;
import com.example.weatherapp.R;
import com.example.weatherapp.weather.WeatherResponse;
import com.example.weatherapp.weather.WeatherService;

import org.jspecify.annotations.NonNull;

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

    private InfoClimaAdapter adapter;
    private List<City> dadosLista = new ArrayList<>();

    // Use sua chave de API
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

        listaInfoCidade.setLayoutManager(new LinearLayoutManager(this));
        adapter = new InfoClimaAdapter(dadosLista, new InfoClimaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(City item) {
                abrirTelaDetalhes(item);
            }
        });
        listaInfoCidade.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);

        btnBuscarCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cidade = nomeCidade.getText().toString().trim();

                if(cidade.isEmpty()){
                    Toast.makeText(MainActivity.this, "Por favor preencha o campo do nome da cidade.",Toast.LENGTH_SHORT).show();
                    return;
                }

                Call<WeatherResponse> call = service.getCurrentWeather(
                        cidade,
                        API_KEY,
                        "metric",
                        "pt_br"
                );
                call.enqueue(new Callback<WeatherResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                        if (response.isSuccessful()) {
                            WeatherResponse weatherData = response.body();

                            // VERIFICAÇÃO DE SEGURANÇA MÁXIMA
                            if (weatherData != null && weatherData.getMain() != null && weatherData.getWeather() != null && !weatherData.getWeather().isEmpty()) {

                                // Preenchimento com segurança, usando os getters da classe MainApi (temperatura, pressao, umidade)
                                String nomeCidadeStr = weatherData.getName() != null ? weatherData.getName() : cidade;
                                String temperaturaStr = String.valueOf(weatherData.getMain().getTemperatura());
                                String descricaoStr = weatherData.getWeather().get(0).getDescription();

                                String umidadeStr = String.valueOf(weatherData.getMain().getUmidade());
                                String pressaoStr = String.valueOf(weatherData.getMain().getPressao());
                                String ventoStr = weatherData.getWind() != null ? String.valueOf(weatherData.getWind().getSpeed()) : "N/A";

                                City novaCidade = new City(
                                        nomeCidadeStr,
                                        temperaturaStr,
                                        descricaoStr,
                                        umidadeStr,
                                        pressaoStr,
                                        ventoStr
                                );

                                dadosLista.add(0, novaCidade);
                                adapter.notifyItemInserted(0);
                            }
                            else {
                                Toast.makeText(MainActivity.this, "Dados da API inválidos.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Log.e("API_CALL", "Erro na resposta: " + response.code());
                            Toast.makeText(MainActivity.this, "Cidade não encontrada. Tente novamente.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                        Log.e("API_CALL", "Falha na requisição: " + t.getMessage());
                        Toast.makeText(MainActivity.this, "Falha na conexão. Verifique sua internet.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    private void abrirTelaDetalhes(City item) {
        Intent intent = new Intent(MainActivity.this, DetalhesActivity.class);
        intent.putExtra("city_object", item); // Passa o objeto City serializável
        startActivity(intent);
    }
}