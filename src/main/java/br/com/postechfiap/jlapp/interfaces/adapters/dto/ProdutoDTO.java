package br.com.postechfiap.jlapp.interfaces.adapters.dto;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.application.domain.entities.Produto;
import lombok.Data;

@Data
public class ProdutoDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("preco")
	private BigDecimal preco;

	@JsonProperty("categoria")
	@JsonInclude(Include.NON_NULL)
	private Long categoria_id;
	
	@JsonProperty("categoria_nome")
	private String categoria_nome;

	@JsonProperty("imagens")
	private List<String> imagens;

	public ProdutoDTO toProdutoDTO(Produto produto) {	
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoria_id = produto.getCategoria().getId();
		this.categoria_nome = produto.getCategoria().getNome();
		this.imagens = produto.getImagens();
		return this;
	}

}
