package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.CategoriaAdpter;

@Configuration
public class CategoriaConfig {

	@Bean
	public CategoriaUseCase categoriaUseCase(CategoriaAdpter categoriaAdapter) {
		return new CategoriaUseCase(categoriaAdapter);
	}
}
