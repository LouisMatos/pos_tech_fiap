package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.PedidoAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.PedidoUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ProdutoUseCase;

@Configuration
public class PedidoConfig {

	@Bean
	public PedidoUseCase pedidoUseCase(PedidoAdapter pedidoAdapter, ClienteUseCase clienteUseCase,
			ProdutoUseCase produtoUseCase) {
		return new PedidoUseCase(pedidoAdapter, clienteUseCase, produtoUseCase);
	}

}
