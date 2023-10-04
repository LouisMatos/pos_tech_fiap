package br.com.postechfiap.jlapp.adapters.in.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import lombok.Data;

@Data
public class ItemPedidoDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("pedido")
	private PedidoDTO pedidoDTO;

	@JsonProperty("produto")
	private ProdutoDTO produtoDTO;

	@JsonProperty("quantidade")
	private int quantidade;

	@JsonProperty("observacao")
	private String observacao;

	public ItemPedidoDTO toItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
//		this.pedidoDTO = new PedidoDTO().toPedidoDTO(itemPedido.getPedido());
		this.produtoDTO = new ProdutoDTO().toProdutoDTO(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
		return this;
	}

}
