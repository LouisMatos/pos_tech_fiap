package br.com.postechfiap.jlapp.adapters.in.controller.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequest {

	@NotBlank
	private String nome;

	@NotBlank
	private String cpf;

}
