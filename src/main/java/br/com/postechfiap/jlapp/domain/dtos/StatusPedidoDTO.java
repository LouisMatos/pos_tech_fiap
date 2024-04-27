package br.com.postechfiap.jlapp.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.domain.enums.StatusPagamento;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusPedidoDTO {

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("status_pagamento")
	private StatusPagamento statusPagamento;

}
