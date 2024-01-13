package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.core.usecase.ItemPedidoUseCase;
import br.com.postechfiap.jlapp.infrastructure.gateway.ItemPedidoAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class ItemPedidoConfig {

	@Bean
	public ItemPedidoUseCase itemPedidoUseCase(ItemPedidoAdapter itemPedidoAdapter, Logger log) {
		return new ItemPedidoUseCase(itemPedidoAdapter, log);
	}

}
