package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.core.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.infrastructure.gateway.ClienteAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class ClienteConfig {

	@Bean
	public ClienteUseCase clienteUseCase(ClienteAdapter clienteAdapter, Logger log) {
		return new ClienteUseCase(clienteAdapter, log);
	}

}
