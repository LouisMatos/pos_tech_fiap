package br.com.postechfiap.jlapp.pedido.data.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteRequestModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import lombok.Data;

@Data
public class PedidoRequestModel {

	private Long id;

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("valor_pedido")
	private BigDecimal valorPedido;

	@JsonProperty("status_pagamento")
	private StatusPagamento statusPagamento;

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("data_pedido")
	private LocalDateTime dataPedido;

	@JsonProperty("cliente")
	private ClienteRequestModel clienteRequestModel;

	@JsonProperty("itens")
	private List<ItemPedidoRequestModel> itemPedidoRequestModels = new ArrayList<>();

	public static Pedido toPedido(PedidoRequestModel pedidoRequestModel) {
		Pedido pedido = new Pedido();
		pedido.setId(pedidoRequestModel.getId());
		pedido.setNumeroPedido(pedidoRequestModel.getNumeroPedido());
		pedido.setValorPedido(pedidoRequestModel.getValorPedido());
		pedido.setStatusPagamento(pedidoRequestModel.getStatusPagamento());
		pedido.setEstado(pedidoRequestModel.getEstado());
		pedido.setDataPedido(pedidoRequestModel.getDataPedido());
		pedido.setCliente(ClienteRequestModel.toCliente(pedidoRequestModel.getClienteRequestModel()));
		pedido.setItemPedidos(ItemPedidoRequestModel.toListItemPedido(pedidoRequestModel.getItemPedidoRequestModels()));
		return pedido;
	}
}
