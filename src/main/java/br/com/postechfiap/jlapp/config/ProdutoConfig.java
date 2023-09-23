package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.ProdutoAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ProdutoUseCase;

@Configuration
public class ProdutoConfig {

	@Bean
	public ProdutoUseCase produtoUseCase(ProdutoAdapter produtoAdapter, CategoriaUseCase categoriaUseCase) {
		return new ProdutoUseCase(produtoAdapter, categoriaUseCase);
	}

}
