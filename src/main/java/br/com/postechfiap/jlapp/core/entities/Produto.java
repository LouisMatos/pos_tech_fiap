package br.com.postechfiap.jlapp.core.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ProdutoDTO;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.ProdutoEntity;

public class Produto {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private Categoria categoria;

	private List<String> imagens = new ArrayList<>();

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

	public Produto toProduto(ProdutoDTO produtoDTO) {
		this.categoria = new Categoria();
		this.id = produtoDTO.getId();
		this.categoria.setNome(produtoDTO.getCategoriaNome());
		this.categoria.setId(produtoDTO.getCategoriaId());
		this.nome = produtoDTO.getNome();
		this.descricao = produtoDTO.getDescricao();
		this.preco = produtoDTO.getPreco();
		this.imagens = produtoDTO.getImagens();
		return this;
	}

	public Produto toProduto(ProdutoEntity produtoEntity) {
		this.id = produtoEntity.getId();
		this.categoria = produtoEntity.getCategoriaEntity().toCategoria();
		this.nome = produtoEntity.getNome();
		this.descricao = produtoEntity.getDescricao();
		this.preco = produtoEntity.getPreco();
		this.imagens = produtoEntity.getImagens();
		return this;
	}

}
