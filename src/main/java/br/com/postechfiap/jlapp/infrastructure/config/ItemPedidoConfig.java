package br.com.postechfiap.jlapp.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.application.core.usecase.ItemPedidoUseCase;
import br.com.postechfiap.jlapp.infrastructure.adapters.ItemPedidoAdapter;

@Configuration
public class ItemPedidoConfig {

	@Bean
	public ItemPedidoUseCase itemPedidoUseCase(ItemPedidoAdapter itemPedidoAdapter) {
		return new ItemPedidoUseCase(itemPedidoAdapter);
	}

}
