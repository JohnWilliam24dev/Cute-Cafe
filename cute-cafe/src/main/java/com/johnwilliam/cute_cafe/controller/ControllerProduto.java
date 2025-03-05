package com.johnwilliam.cute_cafe.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnwilliam.cute_cafe.application.ApplicationProduto;
import com.johnwilliam.cute_cafe.entities.Produto;
import com.johnwilliam.cute_cafe.facade.FacadeProduto;
import com.johnwilliam.cute_cafe.provider.ProviderProduto;
import com.johnwilliam.cute_cafe.repositorie.RepositorieProduto;

@RestController
@RequestMapping("/Produto")
public class ControllerProduto {
		private static RepositorieProduto RepositorieProduto;
		private static ProviderProduto ProviderProduto;
        private static ApplicationProduto ApplicationProduto;
        private static FacadeProduto FacadeProduto;
	private static void injetarDependencias() {
		 RepositorieProduto = new RepositorieProduto();
		 ProviderProduto = new ProviderProduto();
         ApplicationProduto = new ApplicationProduto(RepositorieProduto, ProviderProduto);
         FacadeProduto = new FacadeProduto(ApplicationProduto);
    }
    public ControllerProduto(){
        injetarDependencias();
    }
    @GetMapping
    public ArrayList<Produto> listaProdutos(){
        return FacadeProduto.listaProdutos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable int id){
        Produto produto= FacadeProduto.buscar_Produto_por_id(id);

        return ResponseEntity.status(200).body("Codigo"+produto.getCodigo()+"Nome"+produto.getNome()+"Valor"+produto.getValor());
    }
    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody Produto produto){
        FacadeProduto.cadastrar(produto);
        return ResponseEntity.status(204).body("Produto"+produto.getNome()+"Criado com sucesso");
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarProduto(@PathVariable int id,@RequestBody Produto produto){
        FacadeProduto.atualizar(id, produto);
        return ResponseEntity.status(200).body("Produto atualizado com sucesso");

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable int id){
        Produto produto = FacadeProduto.buscar_Produto_por_id(id);
        FacadeProduto.excluir(id, produto);
        return ResponseEntity.status(200).body("Produto deletado com sucesso");
    }
}
