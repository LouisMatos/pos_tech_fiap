package br.com.postechfiap.jlapp.domain.interfaces;

import br.com.postechfiap.jlapp.domain.dtos.WebhookDTO;

public interface WebhookInputPort {

	public void recuperandoEventoWebhook(WebhookDTO webhookDTO);

}
