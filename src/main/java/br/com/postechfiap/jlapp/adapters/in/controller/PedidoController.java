package br.com.postechfiap.jlapp.adapters.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.PedidoDTO;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/pedidos")
public class PedidoController {

	@Autowired
	private PedidoInputPort pedidoInputPort;

	@PostMapping
	public ResponseEntity<PedidoDTO> inserir(@Valid @RequestBody PedidoDTO pedidoDTO) {
		return ResponseEntity.ok().body(pedidoInputPort.inserir(pedidoDTO));
	}

}
