package br.com.postechfiap.jlapp.core.ports.in;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.WebhookDTO;

public interface WebhookInputPort {

	public void recuperandoEventoWebhook(WebhookDTO webhookDTO);

}
