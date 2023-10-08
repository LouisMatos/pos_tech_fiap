package br.com.postechfiap.jlapp.interfaces.adapters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ClienteDTO;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteInputPort clienteInputPort;

	@PostMapping
	public ResponseEntity<ClienteDTO> inserir(@Valid @RequestBody ClienteDTO clienteDTO) {
		log.info("Iniciando o cadastro de cliente");
		return ResponseEntity.ok().body(clienteInputPort.inserir(clienteDTO));
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ClienteDTO> buscarClientePorCpf(@PathVariable final String cpf) {
		log.info("Iniciando a busca do cliente com o cpf: {}", cpf);
		return ResponseEntity.ok().body(clienteInputPort.buscarClientePorCpf(cpf));
	}

}
