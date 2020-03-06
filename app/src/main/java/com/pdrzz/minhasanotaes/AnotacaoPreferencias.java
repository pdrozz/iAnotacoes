package com.pdrzz.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String PREFERENCIA="caminhoAnotacoes.preferencias";
    private final String CHAVE_ANOTACAO="anotacoes.preferencias";

    public AnotacaoPreferencias(Context c) {
        this.context=c;
        sharedPreferences=context.getSharedPreferences(PREFERENCIA,0);
        editor=sharedPreferences.edit();
    }

    public void salvar(String s){
        editor.putString(CHAVE_ANOTACAO,s);
        editor.commit();
    }



    public String recuperar(){
        return sharedPreferences.getString(CHAVE_ANOTACAO,"");
    }


}
