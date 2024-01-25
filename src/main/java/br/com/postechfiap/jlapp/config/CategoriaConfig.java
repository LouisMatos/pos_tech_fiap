package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.core.usecase.CategoriaUseCase;
import br.com.postechfiap.jlapp.infrastructure.gateway.CategoriaAdpter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class CategoriaConfig {

	@Bean
	public CategoriaUseCase categoriaUseCase(CategoriaAdpter categoriaAdapter, Logger log) {
		return new CategoriaUseCase(categoriaAdapter, log);
	}
}
