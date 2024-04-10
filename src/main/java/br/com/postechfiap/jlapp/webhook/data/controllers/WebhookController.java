package br.com.postechfiap.jlapp.webhook.data.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.core.ports.in.WebhookInputPort;
import br.com.postechfiap.jlapp.webhook.data.models.WebhookRequestModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/webhook")
public class WebhookController {

	@Autowired
	private WebhookInputPort webhookInputPort;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody WebhookRequestModel webhookRequestModel) {
		log.info("Iniciando a coleta do webhook.");
		webhookInputPort.recuperandoEventoWebhook(webhookRequestModel);
		return ResponseEntity.accepted().build();
	}

}
