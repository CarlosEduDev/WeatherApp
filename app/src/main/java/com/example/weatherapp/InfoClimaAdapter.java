package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.jspecify.annotations.NonNull;

import java.util.List;

public class InfoClimaAdapter extends RecyclerView.Adapter<InfoClimaAdapter.InfoClimaViewHolder> {
    private final List<String> dadosClima;

    public InfoClimaAdapter(List<String> dadosClima) {
        this.dadosClima = dadosClima;
    }

    @NonNull
    @Override
    public InfoClimaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_clima, parent, false);
        return new InfoClimaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull InfoClimaAdapter.InfoClimaViewHolder holder, int position) {
        String info = dadosClima.get(position);

        String[] partes = info.split(": ");
        String tipoInfo = partes[0];
        String valorInfo = partes[1];

        // Atualiza a visualização com os dados.
        if (tipoInfo.equals("Cidade")) {
            holder.tvCidade.setText(info);
        } else if (tipoInfo.equals("Temperatura")) {
            holder.tvTemperatura.setText(info);
        } else if (tipoInfo.equals("Descrição")) {
            holder.tvDescricao.setText(info);
        }
    }

    @Override
    public int getItemCount() {
        return dadosClima.size();
    }

    public static class InfoClimaViewHolder extends RecyclerView.ViewHolder {
        public TextView tvCidade;
        public TextView tvTemperatura;
        public TextView tvDescricao;

        public InfoClimaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCidade = itemView.findViewById(R.id.tvCidade);
            tvTemperatura = itemView.findViewById(R.id.tvTemperatura);
            tvDescricao = itemView.findViewById(R.id.tvDescricao);
        }
    }
}
