package br.com.postechfiap.jlapp.domain.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.domain.enums.Estado;
import lombok.Data;

@Data
public class PedidoAcompanhamentoDTO {

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("nome_cliente")
	private String nomeCliente;

	@JsonProperty("data_pedido")
	private LocalDateTime dataPedido;

	public PedidoAcompanhamentoDTO toPedidoAcompanhamento(PedidoDTO pedidoDTO) {
		this.numeroPedido = pedidoDTO.getNumeroPedido();
		this.estado = pedidoDTO.getEstado();
		this.nomeCliente = pedidoDTO.getClienteDTO().getNome();
		this.dataPedido = pedidoDTO.getDataPedido();
		return this;
	}

}
