package br.com.postechfiap.jlapp.pedido.domain.entities;

import br.com.postechfiap.jlapp.produto.domain.entities.Produto;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;

public class ItemPedido {

	private Long id;

	private Long pedidoid;

	private Produto produto;

	private int quantidade;

	private String observacao;

	public ItemPedido() {

	}

	public ItemPedido(Long id, Long pedidoid, Produto produto, int quantidade, String observacao) {
		this.id = id;
		this.pedidoid = pedidoid;
		this.produto = produto;
		this.quantidade = quantidade;
		this.observacao = observacao;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getPedidoid() {
		return pedidoid;
	}

	public void setPedidoid(Long pedidoid) {
		this.pedidoid = pedidoid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", pedidoid=" + pedidoid + ", produto=" + produto + ", quantidade=" + quantidade
				+ ", observacao=" + observacao + "]";
	}

	public ItemPedido toItemPedido(ItemPedidoRequestModel itemPedidoRequestModel) {
		this.id = itemPedidoRequestModel.getId();
		this.pedidoid = itemPedidoRequestModel.getPedidoid();
		this.produto = new Produto().toProduto(itemPedidoRequestModel.getProdutoRequestModel());
		this.quantidade = itemPedidoRequestModel.getQuantidade();
		this.observacao = itemPedidoRequestModel.getObservacao();
		return this;
	}

	public ItemPedido toItemPedido(ItemPedidoModel itemPedidoModel) {
		this.id = itemPedidoModel.getId();
		this.pedidoid = itemPedidoModel.getPedidoid();
		this.produto = new Produto().toProduto(itemPedidoModel.getProdutoModel());
		this.quantidade = itemPedidoModel.getQuantidade();
		this.observacao = itemPedidoModel.getObservacao();
		return this;
	}

}
