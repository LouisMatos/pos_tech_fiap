package br.com.postechfiap.jlapp.categoria.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import lombok.Data;

@Data
public class CategoriaRequestModel {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;

	public CategoriaRequestModel toCategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		return this;
	}

}
