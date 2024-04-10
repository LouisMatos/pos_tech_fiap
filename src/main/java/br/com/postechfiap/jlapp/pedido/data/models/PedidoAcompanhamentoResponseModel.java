package br.com.postechfiap.jlapp.pedido.data.models;

import br.com.postechfiap.jlapp.core.enums.Estado;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoAcompanhamentoResponseModel {

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("nome_cliente")
	private String nomeCliente;

	@JsonProperty("data_pedido")
	private LocalDateTime dataPedido;

	public PedidoAcompanhamentoResponseModel toPedidoAcompanhamento(PedidoRequestModel pedidoRequestModel) {
		this.numeroPedido = pedidoRequestModel.getNumeroPedido();
		this.estado = pedidoRequestModel.getEstado();
		this.nomeCliente = pedidoRequestModel.getClienteRequestModel().getNome();
		this.dataPedido = pedidoRequestModel.getDataPedido();
		return this;
	}

}
