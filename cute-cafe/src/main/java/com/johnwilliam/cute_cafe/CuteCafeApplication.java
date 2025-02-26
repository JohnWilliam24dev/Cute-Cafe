package com.johnwilliam.cute_cafe;

import java.security.Provider;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.johnwilliam.cute_cafe.application.ApplicationProduto;
import com.johnwilliam.cute_cafe.entities.Produto;
import com.johnwilliam.cute_cafe.facade.FacadeProduto;
import com.johnwilliam.cute_cafe.provider.ProviderProduto;
import com.johnwilliam.cute_cafe.repositorie.RepositorieProduto;


@SpringBootApplication
public class CuteCafeApplication {
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
		public static void main(String[] args) {
        // Instanciando a aplicação de produtos e a fachada
        injetarDependencias();
        Scanner scanner = new Scanner(System.in);
		
        int opcao = 0;
        
        do {
            System.out.println("=====================================");
            System.out.println("           MENU DE PRODUTOS          ");
            System.out.println("=====================================");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Buscar Produto por ID");
            System.out.println("5. Excluir Produto");
            System.out.println("6. Comprar Produto");
            System.out.println("7. Sair");
            System.out.println("=====================================");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número.");
                continue;
            }
            
            System.out.println();
            
            switch (opcao) {
                case 1:
                    System.out.println("----- Cadastrar Produto -----");
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Valor: ");
                    float valor = Float.parseFloat(scanner.nextLine());
                    System.out.print("Caminho da Imagem: ");
                    String imagem = scanner.nextLine();
                    
                    // Cria um novo produto com os dados informados
                    Produto novoProduto = new Produto(id, nome, valor, imagem);
                	FacadeProduto.cadastrar(novoProduto);
                    break;
                    
                case 2:
                    System.out.println("----- Atualizar Produto -----");
                    System.out.print("Digite o ID do produto a atualizar: ");
                    int idAtualizar = Integer.parseInt(scanner.nextLine());
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo valor: ");
                    float novoValor = Float.parseFloat(scanner.nextLine());
                    System.out.print("Novo caminho da Imagem: ");
                    String novaImagem = scanner.nextLine();
                    
                    Produto produtoAtualizado = new Produto(idAtualizar, novoNome, novoValor, novaImagem);
                    FacadeProduto.atualizar(idAtualizar, produtoAtualizado);
                    break;
                    
                case 3:
                    System.out.println("----- Lista de Produtos -----");
                    ArrayList<Produto> produtos = FacadeProduto.listaProdutos();
                    if(produtos.isEmpty()){
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for(Produto p : produtos){
                            System.out.println(p);
                        }
                    }
                    break;
                    
                case 4:
                    System.out.println("----- Buscar Produto por ID -----");
                    System.out.print("Digite o ID do produto: ");
                    int idBuscar = Integer.parseInt(scanner.nextLine());
                    Produto produtoEncontrado = FacadeProduto.buscar_Produto_por_id(idBuscar);
                    if(produtoEncontrado != null){
                        System.out.println("Produto encontrado: " + produtoEncontrado);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                    
                case 5:
                    System.out.println("----- Excluir Produto -----");
                    System.out.print("Digite o ID do produto a excluir: ");
                    int idExcluir = Integer.parseInt(scanner.nextLine());
                    Produto produtoExcluir = FacadeProduto.buscar_Produto_por_id(idExcluir);
                    if(produtoExcluir != null){
                    	FacadeProduto.excluir(idExcluir, produtoExcluir);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                    
                case 6:
                    System.out.println("----- Comprar Produto -----");
                    System.out.print("Digite o ID do produto: ");
                    int idCompra = Integer.parseInt(scanner.nextLine());
                    Produto produtoCompra = FacadeProduto.buscar_Produto_por_id(idCompra);
                    if(produtoCompra != null){
                        System.out.print("Digite a quantidade: ");
                        int quantidade = Integer.parseInt(scanner.nextLine());
                        double total = FacadeProduto.comprar(produtoCompra, quantidade);
                        System.out.println("Total da compra: R$" + total);
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                    
                case 7:
                    System.out.println("Saindo do sistema. Até mais!");
                    break;
                    
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            
            System.out.println();
        } while(opcao != 7);
        
        scanner.close();
    }
}
	


