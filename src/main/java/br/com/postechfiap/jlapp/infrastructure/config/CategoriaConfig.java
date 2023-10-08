package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.CategoriaAdpter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class CategoriaConfig {

	@Bean
	public CategoriaUseCase categoriaUseCase(CategoriaAdpter categoriaAdapter, Logger log) {
		return new CategoriaUseCase(categoriaAdapter, log);
	}
}
