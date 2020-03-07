package com.pdrzz.minhasanotaes.model;

public class AnotacoesModel {

    private String titulo, resumo, data;
    private int cor;

    public AnotacoesModel(String titulo, String resumo, String data, int cor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.data = data;
        this.cor = cor;
    }
    public AnotacoesModel(){}

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }
}
