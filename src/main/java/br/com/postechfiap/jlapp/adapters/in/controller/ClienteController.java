package br.com.postechfiap.jlapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.adapters.in.controller.mapper.ClienteMapper;
import br.com.postechfiap.jlapp.adapters.in.controller.request.ClienteRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ClienteResponse;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController {

	@Autowired
	private ClienteInputPort clienteInputPort;

	@Autowired
	private ClienteMapper clienteMapper;

	@PostMapping
	public ResponseEntity<ClienteResponse> inserir(@Valid @RequestBody ClienteRequest clienteRequest) {
		log.info("Iniciando o cadastro de cliente");
		Cliente cliente = clienteMapper.toCliente(clienteRequest);
		ClienteResponse clienteResponse = clienteMapper.toClienteResponse(clienteInputPort.inserir(cliente));
		return ResponseEntity.ok().body(clienteResponse);
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ClienteResponse> buscarClientePorCpf(@PathVariable final String cpf) {
		Cliente cliente = clienteInputPort.buscarClientePorCpf(cpf);
		ClienteResponse clienteResponse = clienteMapper.toClienteResponse(cliente);
		return ResponseEntity.ok().body(clienteResponse);
	}

}