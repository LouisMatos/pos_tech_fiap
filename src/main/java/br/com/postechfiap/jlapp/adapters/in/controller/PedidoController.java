package br.com.postechfiap.jlapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.adapters.in.controller.mapper.PedidoMapper;
import br.com.postechfiap.jlapp.adapters.in.controller.request.PedidoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.PedidoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/api/v1/pedidos")
public class PedidoController {

	@Autowired
	private PedidoInputPort pedidoInputPort;

	@Autowired
	private PedidoMapper pedidoMapper;

	@PostMapping
	public ResponseEntity<PedidoResponse> inserir(@Valid @RequestBody PedidoRequest pedidoRequest) {
		log.info("Iniciando o cadastro de pedido");
		Pedido pedido = pedidoMapper.toPedido(pedidoRequest);
		log.info("Pedido: {}", pedido.toString());
		PedidoResponse pedidoResponse = pedidoMapper.toPedidoResponse(pedidoInputPort.inserir(pedido));
		return ResponseEntity.ok().body(pedidoResponse);
	}

}
