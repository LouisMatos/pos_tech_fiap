package br.com.postechfiap.jlapp.interfaces.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.interfaces.dto.ClienteDTO;

public interface ClienteInputPort {

	public ClienteDTO inserir(ClienteDTO clienteRequest);

	public void atualizar(ClienteDTO clienteRequest);

	public void deletar(Long id);

	public List<ClienteDTO> buscarTodos();

	public ClienteDTO buscarClientePorCpf(String cpf);

}