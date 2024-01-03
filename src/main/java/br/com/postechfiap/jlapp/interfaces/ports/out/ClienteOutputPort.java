package br.com.postechfiap.jlapp.interfaces.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.application.domain.entities.Cliente;

public interface ClienteOutputPort {

	public Cliente inserir(Cliente cliente);

	public void atualizar(Cliente cliente);

	public void deletar(Long id);

	public List<Cliente> buscarTodos();

	public Optional<Cliente> buscarClientePorCpf(String cpf);

}
