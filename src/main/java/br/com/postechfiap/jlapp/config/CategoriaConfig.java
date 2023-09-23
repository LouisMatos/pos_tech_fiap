package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.CategoriaAdpter;
import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;

@Configuration
public class CategoriaConfig {

	@Bean
	public CategoriaUseCase categoriaUseCase(CategoriaAdpter categoriaAdapter) {
		return new CategoriaUseCase(categoriaAdapter);
	}
}
