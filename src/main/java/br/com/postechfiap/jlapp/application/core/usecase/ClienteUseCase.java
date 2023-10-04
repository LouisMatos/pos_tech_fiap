package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.ClienteDTO;
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
	public ClienteDTO inserir(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente().toCliente(clienteDTO);
		ClienteDTO dto = new ClienteDTO().toClienteDTO(clienteOutputPort.inserir(cliente));
		return dto;
	}

	@Override
	public void atualizar(ClienteDTO clienteDTO) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClienteDTO> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO buscar(Long id) {
		ClienteDTO dto = new ClienteDTO().toClienteDTO(clienteOutputPort.buscar(id)
				.orElseThrow(() -> new NotFoundException("Cliente informado não encontrado!")));
		return dto;
	}

	@Override
	public ClienteDTO buscarClientePorCpf(String cpf) {
		ClienteDTO dto = new ClienteDTO().toClienteDTO(clienteOutputPort.buscarClientePorCpf(cpf)
				.orElseThrow(() -> new NotFoundException("Cliente informado não encontrado!")));
		return dto;
	}

}
