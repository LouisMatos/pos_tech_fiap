package br.com.postechfiap.jlapp.aplicacao.adaptatores.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.dominio.portas.interfaces.ClienteServicePort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

	private final ClienteServicePort clienteServicePort;

	public ClienteController(ClienteServicePort clienteServicePort) {
		this.clienteServicePort = clienteServicePort;
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<String> teste() {
		log.info("Function started 'Teste'");
		return new ResponseEntity<>("{\"status\":\"OK\"}", HttpStatus.OK);
	}

}
