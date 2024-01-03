package br.com.postechfiap.jlapp.application.domain.entities;

import java.util.List;

import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.interfaces.adapters.dto.ClienteDTO;

public class Cliente {

	private Long id;

	private String nome;

	private String cpf;

	private String email;

	private List<Pedido> pedidos;

	public Cliente() {
	}

	public Cliente(Long id, String nome, String cpf, String email, List<Pedido> pedidos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.pedidos = pedidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", pedidos=" + pedidos
				+ "]";
	}

	public Cliente toCliente(ClienteDTO clienteDTO) {
		this.id = clienteDTO.getId();
		this.nome = clienteDTO.getNome();
		this.cpf = clienteDTO.getCpf();
		this.email = clienteDTO.getEmail();
		return this;
	}

	public Cliente toCliente(ClienteEntity clienteEntity) {
		this.id = clienteEntity.getId();
		this.nome = clienteEntity.getNome();
		this.cpf = clienteEntity.getCpf();
		this.email = clienteEntity.getEmail();
		return this;
	}

}