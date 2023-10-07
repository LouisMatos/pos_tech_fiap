package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ItemPedidoUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.PedidoUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.ProdutoUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.PedidoAdapter;

@Configuration
public class PedidoConfig {

	@Bean
	public PedidoUseCase pedidoUseCase(PedidoAdapter pedidoAdapter, ClienteUseCase clienteUseCase,
			ProdutoUseCase produtoUseCase, ItemPedidoUseCase itemPedidoUseCase) {
		return new PedidoUseCase(pedidoAdapter, clienteUseCase, produtoUseCase, itemPedidoUseCase);
	}

}
