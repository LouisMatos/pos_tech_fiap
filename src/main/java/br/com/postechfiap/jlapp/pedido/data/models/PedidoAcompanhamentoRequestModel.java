package br.com.postechfiap.jlapp.pedido.data.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.core.enums.Estado;
import lombok.Data;

@Data
public class PedidoAcompanhamentoRequestModel {

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("nome_cliente")
	private String nomeCliente;

	@JsonProperty("data_pedido")
	private LocalDateTime dataPedido;

	public PedidoAcompanhamentoRequestModel toPedidoAcompanhamento(PedidoRequestModel pedidoRequestModel) {
		this.numeroPedido = pedidoRequestModel.getNumeroPedido();
		this.estado = pedidoRequestModel.getEstado();
		this.nomeCliente = pedidoRequestModel.getClienteRequestModel().getNome();
		this.dataPedido = pedidoRequestModel.getDataPedido();
		return this;
	}

}
