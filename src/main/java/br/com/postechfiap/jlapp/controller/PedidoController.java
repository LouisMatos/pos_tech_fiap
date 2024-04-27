package br.com.postechfiap.jlapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.domain.interfaces.PedidoInputPort;
import br.com.postechfiap.jlapp.domain.dtos.PedidoAcompanhamentoDTO;
import br.com.postechfiap.jlapp.domain.dtos.PedidoDTO;
import br.com.postechfiap.jlapp.domain.dtos.StatusPedidoDTO;
import br.com.postechfiap.jlapp.domain.dtos.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/pedidos")
public class PedidoController {

	@Autowired
	private PedidoInputPort pedidoInputPort;

	@Autowired
	private Logger log;

	@PostMapping
	public ResponseEntity<PedidoDTO> inserir(@Valid @RequestBody PedidoDTO pedidoDTO) {
		log.info("Iniciando o cadastro de Pedido!");
		return ResponseEntity.ok().body(pedidoInputPort.inserir(pedidoDTO));
	}
	
	@PostMapping("/status_pagamento/teste")
	public ResponseEntity<StatusPedidoTesteDTO> atualizaStatusPedidoTeste(@RequestBody StatusPedidoTesteDTO statusPedidoTesteDTO) {
		return ResponseEntity.ok().body(pedidoInputPort.atualizaStatusPedidoTeste(statusPedidoTesteDTO));
	}

	@GetMapping
	public ResponseEntity<List<PedidoDTO>> buscarTodos() {
		log.info("Iniciando a busca de todos os Pedidos!");
		return ResponseEntity.ok().body(pedidoInputPort.buscarTodos());
	}
	
	@GetMapping("/{numero_pedido}/status_pagamento")
	public ResponseEntity<StatusPedidoDTO> buscarStatusPagamentoPedido(@PathVariable final String numero_pedido ) {
		log.info("Iniciando a busca pelo status do pedido: {}", numero_pedido);
		return ResponseEntity.ok().body(pedidoInputPort.buscarStatusPagamentoPedido(numero_pedido));
	}
	
	@GetMapping("/acompanhamento")
	public ResponseEntity<List<PedidoAcompanhamentoDTO>> buscarPedidosAcompanhamento() {
		log.info("Iniciando a busca dos pedidos para o acompanhamento!");
		return ResponseEntity.ok().body(pedidoInputPort.buscarPedidosAcompanhamento());
	}
	
	

}
