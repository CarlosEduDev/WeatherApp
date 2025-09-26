package com.example.weatherapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InfoClimaAdapter extends RecyclerView.Adapter<InfoClimaAdapter.InfoClimaViewHolder> {

    private final List<City> dadosClima;
    private final OnItemClickListener listener;

    // Interface para detectar cliques nos itens da lista
    public interface OnItemClickListener {
        void onItemClick(City item);
    }

    public InfoClimaAdapter(List<City> dadosClima, OnItemClickListener listener) {
        this.dadosClima = dadosClima;
        this.listener = listener;
    }

    @NonNull
    @Override
    public InfoClimaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_info_clima, parent, false);
        return new InfoClimaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoClimaViewHolder holder, int position) {
        final City info = dadosClima.get(position);

        // 1. Atualiza a visualização com os dados do objeto City.
        holder.tvCidade.setText("Cidade: " + info.getNome());
        holder.tvTemperatura.setText("Temperatura: " + info.getTemperatura());
        holder.tvDescricao.setText("Descrição: " + info.getDescricao());

        // 2. Configura o clique para o item completo
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(info);
            }
        });
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
