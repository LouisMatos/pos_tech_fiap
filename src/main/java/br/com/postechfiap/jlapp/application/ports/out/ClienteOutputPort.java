package br.com.postechfiap.jlapp.application.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;

public interface ClienteOutputPort {

	public Cliente inserir(Cliente cliente);

	public Optional<Cliente> buscarClientePorCpf(String cpf);

}
