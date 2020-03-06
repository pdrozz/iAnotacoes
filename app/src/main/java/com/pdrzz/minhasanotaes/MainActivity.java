package com.pdrzz.minhasanotaes;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText multLine;
    private AnotacaoPreferencias preferencias;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias=new AnotacaoPreferencias(getApplicationContext());


        multLine=findViewById(R.id.editText);
        multLine.setText(preferencias.recuperar());


       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String a=multLine.getText().toString();
                if(a.equals("") ||a==null){
                   Snackbar.make(view, "Para salvar as anotações é preciso escrever algo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();}
                else{

                    preferencias.salvar(a);
                    Snackbar.make(view,"Salvo com sucesso",Snackbar.LENGTH_LONG).show();


                }



            }
        });
    }


}
