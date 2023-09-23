package br.com.postechfiap.jlapp.adapters.in.controller.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoResponse {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

}
