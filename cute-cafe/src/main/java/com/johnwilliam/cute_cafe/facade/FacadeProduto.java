package com.johnwilliam.cute_cafe.facade;



import java.util.ArrayList;

import com.johnwilliam.cute_cafe.application.ApplicationProduto;
import com.johnwilliam.cute_cafe.entities.Produto;

public class FacadeProduto {

    ApplicationProduto applicationProduto;
    public FacadeProduto(ApplicationProduto applicationProduto){
        this.applicationProduto=applicationProduto;

    }
    public void cadastrar(Produto produto){
        applicationProduto.cadastrar(produto);
    }
    public void atualizar(int id,Produto produto){
        applicationProduto.update(id, produto);

    }
    public ArrayList<Produto> listaProdutos(){
        return applicationProduto.listaProdutos();
    }
    public Produto buscar_Produto_por_id(int id){
        return applicationProduto.buscarByID(id);
    }
    public void excluir(int id, Produto produto){
        applicationProduto.delete(id, produto);
    }
    public double comprar(Produto produto, int quantidade){
        return applicationProduto.calcularLanche(produto, quantidade);
    }
}
