package com.johnwilliam.cute_cafe.entities;




public class Produto {
    private int id;
    private String nome;
    private float valor;
    private String imagem;
    
    public Produto(int id, String nome, float valor,String imagem) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.imagem=imagem;
    }

    public int getCodigo() {
        return id;
    }
    public void setCodigo(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
    public String getImagem() {
        return imagem;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    
}
