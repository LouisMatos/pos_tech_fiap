package br.com.postechfiap.jlapp.core.usecase;

import br.com.postechfiap.jlapp.core.entities.Cliente;
import br.com.postechfiap.jlapp.core.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.core.ports.out.ClienteOutputPort;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ClienteDTO;
import br.com.postechfiap.jlapp.shared.exception.BadRequestException;
import br.com.postechfiap.jlapp.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.shared.utils.ValidaCPF;

public class ClienteUseCase implements ClienteInputPort {

	private final Logger log;

	private final ClienteOutputPort clienteOutputPort;

	public ClienteUseCase(ClienteOutputPort clienteOutputPort, Logger log) {
		this.clienteOutputPort = clienteOutputPort;
		this.log = log;
	}

	@Override
	public ClienteDTO inserir(ClienteDTO clienteDTO) {

		validaCpf(clienteDTO.getCpf());

		log.info("Convertendo para Dominio Cliente");
		Cliente cliente = new Cliente().toCliente(clienteDTO);

		ClienteDTO dto = new ClienteDTO().toClienteDTO(clienteOutputPort.inserir(cliente));
		log.info("{} salvo com sucesso!", dto.toString());
		return dto;
	}

	@Override
	public ClienteDTO buscarClientePorCpf(String cpf) {

		validaCpf(cpf);

		ClienteDTO dto = new ClienteDTO().toClienteDTO(clienteOutputPort.buscarClientePorCpf(cpf)
				.orElseThrow(() -> new NotFoundException("Cliente com o cpf " + cpf + " encontrado!")));
		log.info("Cliente com o cpf {} encontrado!", cpf);
		return dto;
	}

	private void validaCpf(String cpf) {
		if (!ValidaCPF.isValidCPF(cpf)) {
			throw new BadRequestException("CPF " + cpf + " não é valido!");
		}
	}

}
