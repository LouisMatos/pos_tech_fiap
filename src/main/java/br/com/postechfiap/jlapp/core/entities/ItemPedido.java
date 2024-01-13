package br.com.postechfiap.jlapp.core.entities;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.ItemPedidoEntity;

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

	public ItemPedido toItemPedido(ItemPedidoDTO itemPedidoDTO) {
		this.id = itemPedidoDTO.getId();
		this.pedidoid = itemPedidoDTO.getPedidoid();
		this.produto = new Produto().toProduto(itemPedidoDTO.getProdutoDTO());
		this.quantidade = itemPedidoDTO.getQuantidade();
		this.observacao = itemPedidoDTO.getObservacao();
		return this;
	}

	public ItemPedido toItemPedido(ItemPedidoEntity itemPedidoEntity) {
		this.id = itemPedidoEntity.getId();
		this.pedidoid = itemPedidoEntity.getPedidoid();
		this.produto = new Produto().toProduto(itemPedidoEntity.getProdutoEntity());
		this.quantidade = itemPedidoEntity.getQuantidade();
		this.observacao = itemPedidoEntity.getObservacao();
		return this;
	}

}
