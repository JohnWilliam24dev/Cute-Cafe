package com.johnwilliam.cute_cafe.repositorie;
import java.util.ArrayList;
import com.johnwilliam.cute_cafe.entities.Produto;

public class RepositorieProduto {
    ArrayList <Produto> listaProdutos = new ArrayList<Produto>();
    
    public Produto searchProductByID(int id){
        
        return listaProdutos.stream().filter(p->p.getCodigo()==id).findFirst().orElse(null);
        
        
    }
    public ArrayList<Produto> getList(){
        return listaProdutos;
    }
    public void add(Produto product){
        listaProdutos.add(product);

    }
    public void remove(int id){
        if (searchProductByID(id)!=null) {
            listaProdutos.remove(searchProductByID(id));
        }  
    }
    public void update(int id, Produto p){
        Produto productInMemory=searchProductByID(id);
        productInMemory.setNome(p.getNome());
        productInMemory.setValor(p.getValor());
        productInMemory.setImagem(p.getImagem());
        

    }


}
