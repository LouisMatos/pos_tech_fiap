package br.com.postechfiap.jlapp.produto.domain.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;

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

	public Produto toProduto(ProdutoRequestModel produtoRequestModel) {
		this.categoria = new Categoria();
		this.id = produtoRequestModel.getId();
		this.categoria.setNome(produtoRequestModel.getCategoriaNome());
		this.categoria.setId(produtoRequestModel.getCategoriaId());
		this.nome = produtoRequestModel.getNome();
		this.descricao = produtoRequestModel.getDescricao();
		this.preco = produtoRequestModel.getPreco();
		this.imagens = produtoRequestModel.getImagens();
		return this;
	}

	public Produto toProduto(ProdutoModel produtoModel) {
		this.id = produtoModel.getId();
		this.nome = produtoModel.getNome();
		this.descricao = produtoModel.getDescricao();
		this.preco = produtoModel.getPreco();
		this.categoria = new Categoria().toCategoria(produtoModel.getCategoriaModel());
		this.imagens = produtoModel.getImagens();
		return this;
	}

}
