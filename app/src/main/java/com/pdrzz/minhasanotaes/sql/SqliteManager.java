package com.pdrzz.minhasanotaes.sql;

import android.database.sqlite.SQLiteDatabase;

import com.pdrzz.minhasanotaes.R;

public class SqliteManager {

    private String sql="INSERT INTO anotacoes (titulo,conteudo) values ";

    public boolean InserirAnotacao(SQLiteDatabase db,String titulo,String conteudo, String cor,String data){
        if (cor==null || cor.equals("")){
            cor=R.color.cor_fundo_caixa_de_texto+"";
        }

        try{
           db.execSQL("INSERT INTO anotacoes (titulo,conteudo,data) values ('"+titulo+"','"+conteudo+"','"+data+"')");
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }


    }






}
