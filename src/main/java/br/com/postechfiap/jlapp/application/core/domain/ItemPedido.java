package br.com.postechfiap.jlapp.application.core.domain;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ItemPedidoEntity;

public class ItemPedido {

	private Long id;

	private Long id_pedido;

	private Produto produto;

	private int quantidade;

	private String observacao;

	public ItemPedido() {

	}

	public ItemPedido(Long id, Long id_pedido, Produto produto, int quantidade, String observacao) {
		this.id = id;
		this.id_pedido = id_pedido;
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

	public Long getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(Long id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ItemPedido [id=" + id + ", id_pedido=" + id_pedido + ", produto=" + produto + ", quantidade="
				+ quantidade + ", observacao=" + observacao + "]";
	}

	public ItemPedido toItemPedido(ItemPedidoDTO itemPedidoDTO) {
		this.id = itemPedidoDTO.getId();
		this.id_pedido = itemPedidoDTO.getId_pedido();
		this.produto = new Produto().toProduto(itemPedidoDTO.getProdutoDTO());
		this.quantidade = itemPedidoDTO.getQuantidade();
		this.observacao = itemPedidoDTO.getObservacao();
		return this;
	}

	public ItemPedido toItemPedido(ItemPedidoEntity itemPedidoEntity) {
		this.id = itemPedidoEntity.getId();
		this.id_pedido = itemPedidoEntity.getId_pedido();
		this.produto = new Produto().toProduto(itemPedidoEntity.getProdutoEntity());
		this.quantidade = itemPedidoEntity.getQuantidade();
		this.observacao = itemPedidoEntity.getObservacao();
		return this;
	}

}
