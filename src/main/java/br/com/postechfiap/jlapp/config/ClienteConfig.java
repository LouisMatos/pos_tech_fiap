package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.ClienteAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.ClienteUseCase;

@Configuration
public class ClienteConfig {
	
	@Bean
	public ClienteUseCase clienteUseCase(ClienteAdapter clienteAdapter ) {
		return new ClienteUseCase( clienteAdapter);
	}

}
