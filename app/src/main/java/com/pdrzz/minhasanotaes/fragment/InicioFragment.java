package com.pdrzz.minhasanotaes.fragment;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pdrzz.minhasanotaes.R;
import com.pdrzz.minhasanotaes.adapter.ListarAnotacoesAdapter;
import com.pdrzz.minhasanotaes.model.AnotacoesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<AnotacoesModel> listAnotacoes=new ArrayList<>();
    private SQLiteDatabase db;

    public InicioFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_inicio, container, false);

        recyclerView=view.findViewById(R.id.recyclerInicio);

gerarListaTeste();
        ListarAnotacoesAdapter adapter=new ListarAnotacoesAdapter(listAnotacoes);

        //adapter

        //configurar recycler
        layoutManager=new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);



        return view;
    }


    public void gerarListaTeste(){
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));
        listAnotacoes.add(new AnotacoesModel("TESTE Aniversario","Aniversario no dia 23" +
                " do 8 de 2020 não posso esquecer de comprar um...","05/03/2020",3));


    }


}
