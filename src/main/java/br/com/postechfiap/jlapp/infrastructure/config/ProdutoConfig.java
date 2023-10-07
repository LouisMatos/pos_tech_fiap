package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ProdutoUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.ProdutoAdapter;

@Configuration
public class ProdutoConfig {

	@Bean
	public ProdutoUseCase produtoUseCase(ProdutoAdapter produtoAdapter, CategoriaUseCase categoriaUseCase) {
		return new ProdutoUseCase(produtoAdapter, categoriaUseCase);
	}

}
