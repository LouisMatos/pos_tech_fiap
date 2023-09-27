package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.PedidoAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.PedidoUseCase;

@Configuration
public class PedidoConfig {

	@Bean
	public PedidoUseCase pedidoUseCase(PedidoAdapter pedidoAdapter) {
		return new PedidoUseCase(pedidoAdapter);
	}

}
