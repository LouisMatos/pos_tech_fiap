package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import br.com.postechfiap.jlapp.adapters.out.ItemPedidoAdapter;
import br.com.postechfiap.jlapp.application.core.usecase.ItemPedidoUseCase;
import br.com.postechfiap.jlapp.application.core.usecase.PedidoUseCase;

@Configuration
public class ItemPedidoConfig {

	@Bean
	@Lazy
	public ItemPedidoUseCase itemPedidoUseCase(ItemPedidoAdapter itemPedidoAdapter, PedidoUseCase pedidoUseCase) {
		return new ItemPedidoUseCase(itemPedidoAdapter, pedidoUseCase);
	}

}
