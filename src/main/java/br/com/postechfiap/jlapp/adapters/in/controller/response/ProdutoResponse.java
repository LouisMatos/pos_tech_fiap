package br.com.postechfiap.jlapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.util.List;

import lombok.Data;

@Data
public class ProdutoResponse {

	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;
	
//	private Long categoria;

	private List<String> imagens;

}
