package br.com.postechfiap.jlapp.categoria.domain.entities;

import java.util.List;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaRequestModel;
import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;

public class Categoria {

	private Long id;

	private String nome;

	private String descricao;

	private List<Produto> produtos;

	public Categoria() {

	}

	public Categoria(Long id, String nome, String descricao, List<Produto> produtos) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.produtos = produtos;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", produtos=" + produtos + "]";
	}

	public Categoria toCategoria(CategoriaRequestModel categoriaRequestModel) {
		this.id = categoriaRequestModel.getId();
		this.nome = categoriaRequestModel.getNome();
		this.descricao = categoriaRequestModel.getDescricao();
		return this;
	}

	public Categoria toCategoria(CategoriaModel categoriaModel) {
		this.id = categoriaModel.getId();
		this.nome = categoriaModel.getNome();
		this.descricao = categoriaModel.getDescricao();
		return this;
	}

}
