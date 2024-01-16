package br.com.postechfiap.jlapp.infrastructure.controllers.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.core.entities.Pedido;
import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import lombok.Data;

@Data
public class PedidoDTO {

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
	private ClienteDTO clienteDTO;

	@JsonProperty("itens")
	private List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<>();

	public PedidoDTO toPedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.numeroPedido = pedido.getNumeroPedido();
		this.statusPagamento = pedido.getStatusPagamento();
		if (pedido.getCliente() != null) {
			this.clienteDTO = new ClienteDTO().toClienteDTO(pedido.getCliente());
		}
		this.itemPedidoDTOs = pedido.getItens().stream().map(p -> new ItemPedidoDTO().toItemPedidoDTO(p))
				.collect((Collectors.toList()));
		this.estado = pedido.getEstado();
		this.dataPedido = pedido.getDataPedido();
		this.valorPedido = pedido.getValorPedido();
		return this;
	}
}
