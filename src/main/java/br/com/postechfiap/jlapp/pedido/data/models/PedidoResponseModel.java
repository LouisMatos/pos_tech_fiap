package br.com.postechfiap.jlapp.pedido.data.models;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteRequestModel;
import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class PedidoResponseModel {

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

    public static PedidoResponseModel toPedidoResponseModel(Pedido pedido) {
		PedidoResponseModel pedidoResponseModel = new PedidoResponseModel();
		pedidoResponseModel.setId(pedido.getId());
		pedidoResponseModel.setNumeroPedido(pedido.getNumeroPedido());
		pedidoResponseModel.setValorPedido(pedido.getValorPedido());
		pedidoResponseModel.setStatusPagamento(pedido.getStatusPagamento());
		pedidoResponseModel.setEstado(pedido.getEstado());
		pedidoResponseModel.setDataPedido(pedido.getDataPedido());
		pedidoResponseModel.setClienteRequestModel(ClienteRequestModel.toClienteRequestModel(pedido.getCliente()));
		pedidoResponseModel.setItemPedidoRequestModels(ItemPedidoRequestModel.toListItemPedido(pedido.getItemPedidos()));
		return pedidoResponseModel;
    }

	public static List<PedidoResponseModel> toListaPedidoResponseModel(List<Pedido> pedidos) {
		List<PedidoResponseModel> pedidoResponseModels = new ArrayList<>();
		for (Pedido pedido : pedidos) {
			pedidoResponseModels.add(toPedidoResponseModel(pedido));
		}
		return pedidoResponseModels;
	}
}
