package br.com.postechfiap.jlapp.adapters.in.controller.request;

import java.math.BigDecimal;

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

}
