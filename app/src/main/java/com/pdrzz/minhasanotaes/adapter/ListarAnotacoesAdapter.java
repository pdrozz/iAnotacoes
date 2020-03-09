package com.pdrzz.minhasanotaes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pdrzz.minhasanotaes.R;
import com.pdrzz.minhasanotaes.model.AnotacoesModel;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class ListarAnotacoesAdapter extends RecyclerView.Adapter<ListarAnotacoesAdapter.MeuViewHolder> {

    List<AnotacoesModel> listaAnotacoes=new ArrayList<>();


    public ListarAnotacoesAdapter(List<AnotacoesModel> listaAnotacoes) {
        this.listaAnotacoes = listaAnotacoes;
    }

    public ListarAnotacoesAdapter(){}

        public class MeuViewHolder extends RecyclerView.ViewHolder{
                    TextView titulo,data,resumo;
                public MeuViewHolder(@NonNull View itemView) {
                    super(itemView);
                    titulo=itemView.findViewById(R.id.txtTitulo);
                    data=itemView.findViewById(R.id.txtData);
                    resumo=itemView.findViewById(R.id.txtResumo);
                }
             }

    @NonNull
    @Override
    public MeuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_anotacoes,parent,false);

            return new MeuViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MeuViewHolder holder, int position) {
        AnotacoesModel model=listaAnotacoes.get(position);
        holder.titulo.setText(model.getTitulo()+position);
        holder.resumo.setText(model.getResumo());
        holder.data.setText(model.getData());
    }

    @Override
    public int getItemCount() {
        return listaAnotacoes.size();
    }
}
