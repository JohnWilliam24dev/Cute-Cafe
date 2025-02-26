package com.johnwilliam.cute_cafe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.johnwilliam.cute_cafe.entities.Produto;
import com.johnwilliam.cute_cafe.provider.ProviderProduto;

@SpringBootTest
class CuteCafeApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("debug 1");
		Produto produto_teste= new Produto(1,"hamburguer", 15,"/home/john/Imagens/fotocomida.jpg");
		System.out.println("debug 2");
		ProviderProduto provider= new ProviderProduto();
		System.out.println("debug 3");
		provider.save(produto_teste);
		System.out.println("debug 4");
		System.out.println(produto_teste.getImagem());

	}

}
      