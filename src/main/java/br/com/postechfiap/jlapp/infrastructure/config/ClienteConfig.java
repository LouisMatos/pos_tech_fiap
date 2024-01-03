package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.ClienteAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class ClienteConfig {

	@Bean
	public ClienteUseCase clienteUseCase(ClienteAdapter clienteAdapter, Logger log) {
		return new ClienteUseCase(clienteAdapter, log);
	}

}
