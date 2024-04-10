package br.com.postechfiap.jlapp.pedido.data.controllers;

import java.util.List;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoResponseModel;
import br.com.postechfiap.jlapp.pedido.domain.usecases.PedidoUseCase;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoResponseModel;
import br.com.postechfiap.jlapp.webhook.data.models.StatusPedidoResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.pedido.domain.repositories.PedidoRepository;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoAcompanhamentoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoRequestModel;
import br.com.postechfiap.jlapp.webhook.data.models.StatusPedidoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/pedidos")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    private final Logger log;

    public PedidoController(PedidoUseCase pedidoUseCase, Logger log) {
        this.pedidoUseCase = pedidoUseCase;
        this.log = log;
    }

    @PostMapping
    public ResponseEntity<PedidoResponseModel> inserir(@Valid @RequestBody PedidoRequestModel pedidoRequestModel) {
        log.info("Iniciando o cadastro de Pedido!");
		PedidoResponseModel pedidoResponseModel = PedidoResponseModel.toPedidoResponseModel(pedidoUseCase.inserir(PedidoRequestModel.toPedido(pedidoRequestModel)));
        return ResponseEntity.ok().body(pedidoResponseModel);
    }

    @PostMapping("/status_pagamento/teste")
    public ResponseEntity<StatusPedidoTesteDTO> atualizaStatusPedidoTeste(@RequestBody StatusPedidoTesteDTO statusPedidoTesteDTO) {
        return ResponseEntity.ok().body(pedidoUseCase.atualizaStatusPedidoTeste(statusPedidoTesteDTO));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseModel>> buscarTodos() {
        log.info("Iniciando a busca de todos os Pedidos!");
        PedidoResponseModel pedidoResponseModel = new PedidoResponseModel();
        return ResponseEntity.ok().body(PedidoResponseModel.toListaPedidoResponseModel(pedidoUseCase.buscarTodos()));
    }

    @GetMapping("/{numero_pedido}/status_pagamento")
    public ResponseEntity<StatusPedidoResponseModel> buscarStatusPagamentoPedido(@PathVariable final String numero_pedido) {
        log.info("Iniciando a busca pelo status do pedido: {}", numero_pedido);
        return ResponseEntity.ok().body(pedidoUseCase.buscarStatusPagamentoPedido(numero_pedido));
    }

    @GetMapping("/acompanhamento")
    public ResponseEntity<List<PedidoAcompanhamentoRequestModel>> buscarPedidosAcompanhamento() {
        log.info("Iniciando a busca dos pedidos para o acompanhamento!");
        return ResponseEntity.ok().body(pedidoRepository.buscarPedidosAcompanhamento());
    }


}
