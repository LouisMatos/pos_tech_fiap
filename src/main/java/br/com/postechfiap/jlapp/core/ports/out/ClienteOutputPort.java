package br.com.postechfiap.jlapp.core.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.core.entities.Cliente;

public interface ClienteOutputPort {

	public Cliente inserir(Cliente cliente);

	public Optional<Cliente> buscarClientePorCpf(String cpf);

}
