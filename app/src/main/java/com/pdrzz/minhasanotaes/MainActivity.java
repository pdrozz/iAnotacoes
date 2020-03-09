package com.pdrzz.minhasanotaes;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.pdrzz.minhasanotaes.adapter.ListarAnotacoesAdapter;
import com.pdrzz.minhasanotaes.fragment.InicioFragment;
import com.pdrzz.minhasanotaes.fragment.TextFragment;
import com.pdrzz.minhasanotaes.model.AnotacoesModel;
import com.pdrzz.minhasanotaes.sql.SqliteManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText multLine, titulo;
    private AnotacaoPreferencias preferencias;
    private TextFragment txtfragment;

    private InicioFragment fragmentInicio= new InicioFragment();
    private int frame = R.id.frame, count = 0;
    //count
    // 0: inicial
    // 1: text
    // 3: salvar text


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);
        preferencias = new AnotacaoPreferencias(getApplicationContext());
        final FloatingActionButton fab = findViewById(R.id.fab);
        multLine = findViewById(R.id.multLine);
        titulo = findViewById(R.id.editTitulo);


        configInicial();
        SQLiteDatabase db = dbOpenOrCreate();
        txtfragment = new TextFragment(fab,db);

        fabClick(fab);


    }

    public void trocarIconFab(final FloatingActionButton fab) {
        if (count == 0) {
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add));
        } else {
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_done));
        }
    }





    public SQLiteDatabase dbOpenOrCreate() {
        try {
            SQLiteDatabase db = openOrCreateDatabase("anotacoes", MODE_PRIVATE, null);
            db.execSQL("CREATE TABLE IF NOT EXISTS anotacoes (id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR, conteudo VARCHAR, cor VARCHAR,data DATE)");
            return db;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void configInicial() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(frame, fragmentInicio, "tagInicio");
        transaction.commit();
    }

    public void fabClick(final FloatingActionButton floatAB
    ) {
        floatAB.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (count == 0) {
                    FragmentTransaction trs = getSupportFragmentManager().beginTransaction();
                    trs.replace(frame, txtfragment);
                    trs.commit();
                    count = 1;
                    System.out.println("count :" + count);
                    trocarIconFab(floatAB);

                } else{
                    count = 0;
                    FragmentTransaction trss = getSupportFragmentManager().beginTransaction();
                    trss.replace(frame, fragmentInicio);
                    trss.commit();
                    System.out.println("count :" + count);
                    trocarIconFab(floatAB);


/*
                    if (!contain.equals("")) {

                        boolean a = sqliteManager.InserirAnotacao(database, title, contain, null);
                        System.out.println("INSERIDO " + a);
                    }*/
                }

            }

        });
        System.out.println("count :" + count);

    }


}
