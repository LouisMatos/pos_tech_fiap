package br.com.postechfiap.jlapp.application.core.domain;

import java.math.BigDecimal;
import java.util.List;

public class Produto {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private Categoria categoria;

	private List<String> imagens;

	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, BigDecimal preco, Categoria categoria,
			List<String> imagens) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.categoria = categoria;
		this.imagens = imagens;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<String> getImagens() {
		return imagens;
	}

	public void setImagens(List<String> imagens) {
		this.imagens = imagens;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria="
				+ categoria + ", imagens=" + imagens + "]";
	}

}
