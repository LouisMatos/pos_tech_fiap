package br.com.postechfiap.jlapp.application.core.domain;

public class ItemPedido {

	private Produto produto;

	private int quantidade;

	private String observacao;

	public ItemPedido() {

	}

	public ItemPedido(Produto produto, int quantidade, String observacao) {
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

	@Override
	public String toString() {
		return "ItemPedido [produto=" + produto + ", quantidade=" + quantidade + ", observacao=" + observacao + "]";
	}

}
