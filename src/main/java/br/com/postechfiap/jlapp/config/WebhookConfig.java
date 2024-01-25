package br.com.postechfiap.jlapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.postechfiap.jlapp.core.usecase.PedidoUseCase;
import br.com.postechfiap.jlapp.core.usecase.WebhookUseCase;
import br.com.postechfiap.jlapp.infrastructure.gateway.WebhookAdapter;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Configuration
public class WebhookConfig {

	@Bean
	public WebhookUseCase webhookUseCase(WebhookAdapter adapter, PedidoUseCase pedidoUseCase, Logger log) {
		return new WebhookUseCase(adapter, pedidoUseCase, log);
	}

}
