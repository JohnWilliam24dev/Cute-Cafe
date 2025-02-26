package com.johnwilliam.cute_cafe.application;

import com.johnwilliam.cute_cafe.entities.Produto;
import com.johnwilliam.cute_cafe.provider.ProviderProduto;
import com.johnwilliam.cute_cafe.repositorie.RepositorieProduto;

public class ApplicationProduto {
    private RepositorieProduto repositorieProduto;
    private ProviderProduto providerProduto;

    public ApplicationProduto(RepositorieProduto repositorieProduto,ProviderProduto providerProduto){
        this.repositorieProduto=repositorieProduto;
        this.providerProduto=providerProduto;
    }
    public void cadastrar(Produto produto){
        repositorieProduto.add(produto);
        providerProduto.save(produto);
    }
    public void update(int id,Produto produto){
        repositorieProduto.update(id, produto);
        providerProduto.update(produto);
    }
    public void delete(int id, Produto produto){
        repositorieProduto.remove(id);
        providerProduto.delete(produto);

    }
    public Produto buscarByID(int id){
        return repositorieProduto.searchProductByID(id);
    }
}
