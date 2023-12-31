package br.com.postechfiap.jlapp.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ClienteDTO {

	@JsonProperty("id")
	private Long id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("cpf")
	private String cpf;

	@Email
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
