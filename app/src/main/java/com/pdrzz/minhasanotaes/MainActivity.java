package com.pdrzz.minhasanotaes;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.pdrzz.minhasanotaes.adapter.ListarAnotacoesAdapter;
import com.pdrzz.minhasanotaes.fragment.InicioFragment;
import com.pdrzz.minhasanotaes.fragment.TextFragment;
import com.pdrzz.minhasanotaes.model.AnotacoesModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private EditText multLine;
    private AnotacaoPreferencias preferencias;
    private TextFragment txtfragment=new TextFragment();
    private InicioFragment fragmentInicio=new InicioFragment();
    private int frame=R.id.frame,count=0;
    //count
    // 0: inicial
    // 1: text



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);
        preferencias=new AnotacaoPreferencias(getApplicationContext());



        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(frame,fragmentInicio,"tagInicio");
        transaction.commit();

        //multLine=findViewById(R.id.editText);
        //multLine.setText(preferencias.recuperar());



       final FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v,"long", Snackbar.LENGTH_LONG).show();
                return false;
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(count==0){

                FragmentTransaction trs=getSupportFragmentManager().beginTransaction();
                trs.replace(frame,txtfragment);
                trs.commit();
                count=1;
                trocarIconFab(fab);
                }else{
                    count=0;
                    trocarIconFab(fab);
                    FragmentTransaction trss=getSupportFragmentManager().beginTransaction();
                    trss.replace(frame,fragmentInicio);
                    trss.commit();
                }


             /*   String a=multLine.getText().toString();
                if(a.equals("") ||a==null){
                   Snackbar.make(view, "Para salvar as anotações é preciso escrever algo", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();}
                else{

                    preferencias.salvar(a);
                    Snackbar.make(view,"Salvo com sucesso",Snackbar.LENGTH_LONG).show();


                }*/



            }
        });


        //setando icone adição
        getFragmentManager().executePendingTransactions();
        if( !fragmentInicio.isVisible()){
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add));
        }

    }

public void trocarIconFab(FloatingActionButton fab){
        if(count==0){
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_add));
        }else{
            fab.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_done));
        }

}



}
