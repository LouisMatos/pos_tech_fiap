package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;

public interface ClienteOutputPort {

	public Cliente inserir(Cliente cliente);

	public void atualizar(Cliente cliente);

	public void deletar(Long id);

	public List<Cliente> buscarTodos();

	public Optional<Cliente> buscar(Long id);
	
	public Optional<Cliente> buscarClientePorCpf(String cpf);

}
