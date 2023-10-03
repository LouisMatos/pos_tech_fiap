package br.com.postechfiap.jlapp.adapters.in.controller.response;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import lombok.Data;

@Data
public class CategoriaResponse {

	private Long id;

	private String nome;

	private String descricao;

	public CategoriaResponse toCategoriaResponse(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		return this;
	}
}
