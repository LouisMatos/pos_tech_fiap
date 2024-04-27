package br.com.postechfiap.jlapp.domain.usecase;

import br.com.postechfiap.jlapp.domain.dtos.ClienteDTO;
import br.com.postechfiap.jlapp.domain.entities.Cliente;
import br.com.postechfiap.jlapp.domain.exceptions.BadRequestException;
import br.com.postechfiap.jlapp.domain.exceptions.NotFoundException;
import br.com.postechfiap.jlapp.domain.interfaces.ClienteInputPort;
import br.com.postechfiap.jlapp.domain.repositories.IClienteRepository;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;
import br.com.postechfiap.jlapp.infra.utils.ValidaCPF;

public class ClienteUseCase implements ClienteInputPort {

	private final Logger log;

	private final IClienteRepository IClienteRepository;

	public ClienteUseCase(IClienteRepository IClienteRepository, Logger log) {
		this.IClienteRepository = IClienteRepository;
		this.log = log;
	}

	@Override
	public ClienteDTO inserir(ClienteDTO clienteDTO) {

		validaCpf(clienteDTO.getCpf());

		log.info("Convertendo para Dominio Cliente");
		Cliente cliente = new Cliente().toCliente(clienteDTO);

		ClienteDTO dto = new ClienteDTO().toClienteDTO(IClienteRepository.inserir(cliente));
		log.info("{} salvo com sucesso!", dto.toString());
		return dto;
	}

	@Override
	public ClienteDTO buscarClientePorCpf(String cpf) {

		validaCpf(cpf);

		ClienteDTO dto = new ClienteDTO().toClienteDTO(IClienteRepository.buscarClientePorCpf(cpf)
				.orElseThrow(() -> new NotFoundException("Cliente com o cpf " + cpf + " não encontrado!")));
		log.info("Cliente com o cpf {} encontrado!", cpf);
		return dto;
	}

	private void validaCpf(String cpf) {
		if (!ValidaCPF.isValidCPF(cpf)) {
			throw new BadRequestException("CPF " + cpf + " não é valido!");
		}
	}

}
