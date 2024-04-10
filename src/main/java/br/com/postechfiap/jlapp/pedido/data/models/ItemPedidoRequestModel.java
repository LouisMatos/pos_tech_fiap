package br.com.postechfiap.jlapp.pedido.data.models;

import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import lombok.Data;

import java.util.List;

@Data
public class ItemPedidoRequestModel {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("pedido")
	private Long pedidoid;

	@JsonProperty("produto")
	private ProdutoRequestModel produtoRequestModel;

	@JsonProperty("quantidade")
	private int quantidade;

	@JsonProperty("observacao")
	private String observacao;

    public static ItemPedidoRequestModel toListItemPedido(List<ItemPedidoRequestModel> itemPedidoRequestModels) {
    }

    public ItemPedidoRequestModel toItemPedidoDTO(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.pedidoid = itemPedido.getPedidoid();
		this.produtoRequestModel = new ProdutoRequestModel().toProdutoDTO(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
		return this;
	}

}
