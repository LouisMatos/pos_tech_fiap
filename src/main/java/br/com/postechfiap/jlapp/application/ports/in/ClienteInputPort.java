package br.com.postechfiap.jlapp.application.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;

public interface ClienteInputPort {

	public void inserir(Cliente cliente);

	public void atualizar(Cliente cliente);

	public void deletar(Long id);

	public List<Cliente> buscarTodos();

	public Cliente buscar(Long id);
	
	public Cliente buscarClientePorCpf(String cpf);

}
