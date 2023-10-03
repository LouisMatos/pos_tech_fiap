package br.com.postechfiap.jlapp.application.core.domain;

import java.util.List;

import br.com.postechfiap.jlapp.adapters.in.controller.response.CategoriaResponse;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.CategoriaEntity;

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

	public Categoria toCategoria(CategoriaResponse categoriaResponse) {
		this.id = categoriaResponse.getId();
		this.nome = categoriaResponse.getNome();
		this.descricao = categoriaResponse.getDescricao();
		return this;
	}

	public Categoria toCategoria(CategoriaEntity categoriaEntity) {
		this.id = categoriaEntity.getId();
		this.nome = categoriaEntity.getNome();
		this.descricao = categoriaEntity.getDescricao();
		return this;
	}

}
