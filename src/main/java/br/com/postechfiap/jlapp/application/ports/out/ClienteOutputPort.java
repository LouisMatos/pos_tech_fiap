package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;

public interface ClienteOutputPort {

	public void inserir(Cliente cliente);

	public void atualizar(Cliente cliente);

	public void deletar(Long id);

	public List<Cliente> buscarTodos();

	public Cliente buscar(Long id);

}
