package com.pdrzz.minhasanotaes.fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.pdrzz.minhasanotaes.R;
import com.pdrzz.minhasanotaes.sql.SqliteManager;

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;

/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment{

    public TextFragment(FloatingActionButton floatingActionButton,SQLiteDatabase db) {
        this.fab=floatingActionButton;
        this.db=db;
    }


    public TextFragment() {
        // Required empty public constructor
    }

    private FloatingActionButton fab;
    private SQLiteDatabase db;
    private EditText titulo,conteudo;
    String title,con;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_text, container, false);
        titulo=view.findViewById(R.id.editTitulo);
        conteudo=view.findViewById(R.id.multLine);




if(fab!=null && db!=null){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SqliteManager sqliteManager=new SqliteManager();
                try{

                    title=titulo.getText().toString();
                    con=conteudo.getText().toString();
                db.execSQL("INSERT INTO anotacoes (titulo,conteudo) values ('"+title+"','"+con+"'DATE())');");

                    Toast.makeText(getActivity().getApplicationContext(),"BOOOOA",Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(),e+"",Toast.LENGTH_LONG).show();
                }          }
        });
}



        return view;
    }

}
