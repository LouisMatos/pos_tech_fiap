package br.com.postechfiap.jlapp.adapters.in.controller.dto;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import lombok.Data;

@Data
public class ClienteDTO {

	private Long id;

	private String nome;

	private String cpf;

	private String email;

	public ClienteDTO toClienteDTO(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		return this;
	}

}
