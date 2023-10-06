package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.out.ClienteAdapter;

@Configuration
public class ClienteConfig {

	@Bean
	public ClienteUseCase clienteUseCase(ClienteAdapter clienteAdapter) {
		return new ClienteUseCase(clienteAdapter);
	}

}
