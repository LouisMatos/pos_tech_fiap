package br.com.postechfiap.jlapp.domain.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.domain.entities.Categoria;
import lombok.Data;

@Data
public class CategoriaDTO {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;

	public CategoriaDTO toCategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		return this;
	}

	public CategoriaDTO(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
}
