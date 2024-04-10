package br.com.postechfiap.jlapp.categoria.data.models;

import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CategoriaResponseModel {
	
	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;

	public CategoriaResponseModel toCategoriaDTO(Categoria categoria) {
		this.id = categoria.getId();
		this.nome = categoria.getNome();
		this.descricao = categoria.getDescricao();
		return this;
	}

}
