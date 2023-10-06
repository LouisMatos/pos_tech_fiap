package br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import lombok.Data;

@Data
public class PedidoDTO {

	private Long id;

	@JsonProperty("cliente")
	private ClienteDTO clienteDTO;

	@JsonProperty("itens")
	private List<ItemPedidoDTO> itemPedidoDTOs = new ArrayList<ItemPedidoDTO>();

	@JsonProperty("estado")
	private Estado estado;

	@JsonProperty("data_pedido")
	private LocalDateTime data_pedido;

	@JsonProperty("valor_pedido")
	private BigDecimal valor_pedido;

	public PedidoDTO toPedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		if (pedido.getCliente() != null) {
			this.clienteDTO = new ClienteDTO().toClienteDTO(pedido.getCliente());
		}
		this.itemPedidoDTOs = pedido.getItens().stream().map(p -> new ItemPedidoDTO().toItemPedidoDTO(p))
				.collect((Collectors.toList()));

		this.estado = pedido.getEstado();
		this.data_pedido = pedido.getData_pedido();
		this.valor_pedido = pedido.getValor_pedido();
		return this;
	}
}
