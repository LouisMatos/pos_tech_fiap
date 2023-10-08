package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ProdutoUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.ProdutoAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class ProdutoConfig {

	@Bean
	public ProdutoUseCase produtoUseCase(ProdutoAdapter produtoAdapter, CategoriaUseCase categoriaUseCase, Logger log) {
		return new ProdutoUseCase(produtoAdapter, categoriaUseCase, log);
	}

}
