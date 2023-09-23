package br.com.postechfiap.jlapp.adapters.in.controller.request;

import java.math.BigDecimal;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProdutoRequest {

	@NotBlank
	private String nome;

	@NotBlank
	private String descricao;

	@NotNull
	private BigDecimal preco;
	
	@NotNull
	private Long categoria;

	@NotNull
	private List<String> imagens;

}
