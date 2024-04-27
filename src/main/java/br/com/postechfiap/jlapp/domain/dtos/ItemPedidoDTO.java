package br.com.postechfiap.jlapp.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.domain.entities.ItemPedido;
import lombok.Data;

@Data
public class ItemPedidoDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("pedido")
	private Long pedidoid;

	@JsonProperty("produto")
	private ProdutoDTO produtoDTO;

	@JsonProperty("quantidade")
	private int quantidade;

	@JsonProperty("observacao")
	private String observacao;

	public ItemPedidoDTO toItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.pedidoid = itemPedido.getPedidoid();
		this.produtoDTO = new ProdutoDTO().toProdutoDTO(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
		return this;
	}

}
