package br.com.postechfiap.jlapp.domain.repositories;

import java.util.Optional;

import br.com.postechfiap.jlapp.domain.entities.Cliente;

public interface IClienteRepository {

	public Cliente inserir(Cliente cliente);

	public Optional<Cliente> buscarClientePorCpf(String cpf);

}
