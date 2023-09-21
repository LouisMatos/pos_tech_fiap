package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ClienteOutputPort;

public class ClienteUseCase implements ClienteInputPort {

	private final ClienteOutputPort clienteOutputPort;

	public ClienteUseCase(ClienteOutputPort clienteOutputPort) {
		this.clienteOutputPort = clienteOutputPort;
	}

	@Override
	public void inserir(Cliente cliente) {
		clienteOutputPort.inserir(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscar(Long id) {
		return clienteOutputPort.buscar(id).orElseThrow(() -> new NotFoundException("Cliente informado não encontrado!"));
	}

}
