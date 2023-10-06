package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.adapters.out.ItemPedidoAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.ItemPedidoUseCase;

@Configuration
public class ItemPedidoConfig {

	@Bean
	public ItemPedidoUseCase itemPedidoUseCase(ItemPedidoAdapter itemPedidoAdapter) {
		return new ItemPedidoUseCase(itemPedidoAdapter);
	}

}
