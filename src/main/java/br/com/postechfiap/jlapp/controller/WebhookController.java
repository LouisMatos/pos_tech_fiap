package br.com.postechfiap.jlapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.domain.interfaces.WebhookInputPort;
import br.com.postechfiap.jlapp.domain.dtos.WebhookDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/webhook")
public class WebhookController {

	@Autowired
	private WebhookInputPort webhookInputPort;

	@PostMapping
	public ResponseEntity<Void> inserir(@RequestBody WebhookDTO webhookDTO) {
		log.info("Iniciando a coleta do webhook.");
		webhookInputPort.recuperandoEventoWebhook(webhookDTO);
		return ResponseEntity.accepted().build();
	}

}
