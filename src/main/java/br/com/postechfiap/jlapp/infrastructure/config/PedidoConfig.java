package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.domain.usecase.ClienteUseCase;
import br.com.postechfiap.jlapp.application.domain.usecase.ItemPedidoUseCase;
import br.com.postechfiap.jlapp.application.domain.usecase.PedidoUseCase;
import br.com.postechfiap.jlapp.application.domain.usecase.ProdutoUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.PedidoAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class PedidoConfig {

	@Bean
	public PedidoUseCase pedidoUseCase(PedidoAdapter pedidoAdapter, ClienteUseCase clienteUseCase,
			ProdutoUseCase produtoUseCase, ItemPedidoUseCase itemPedidoUseCase, Logger log) {
		return new PedidoUseCase(pedidoAdapter, clienteUseCase, produtoUseCase, itemPedidoUseCase, log);
	}

}
