package br.com.postechfiap.jlapp.core.ports.in;

import br.com.postechfiap.jlapp.webhook.data.models.WebhookRequestModel;

public interface WebhookInputPort {

	public void recuperandoEventoWebhook(WebhookRequestModel webhookRequestModel);

}
