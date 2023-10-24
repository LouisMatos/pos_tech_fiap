package br.com.postechfiap.jlapp.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteDTO {

	@JsonProperty("id")
	private Long id;

	@NotBlank
	@JsonProperty("nome")
	private String nome;

	@NotBlank
	@JsonProperty("cpf")
	private String cpf;

	@Email
	@NotBlank
	@JsonProperty("email")
	private String email;

	public ClienteDTO toClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		return this;
	}

}
