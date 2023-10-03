package br.com.postechfiap.jlapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Produto;
import lombok.Data;

@Data
public class ProdutoResponse {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	private String categoria;

	private List<String> imagens;

	public ProdutoResponse toProdutoResponse(Produto produto) {
		this.id = produto.getId();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.categoria = produto.getCategoria().getNome();
		this.imagens = produto.getImagens();
		return this;
	}

}
