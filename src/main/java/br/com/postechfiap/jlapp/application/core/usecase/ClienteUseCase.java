package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.exception.BadRequestException;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ClienteOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ClienteDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.shared.utils.ValidaCPF;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ClienteUseCase implements ClienteInputPort {

    private final Logger log;
    private final ClienteOutputPort clienteOutputPort;

    @Override
    public ClienteDTO inserir(ClienteDTO clienteDTO) {
        validaCpf(clienteDTO.getCpf());
        log.info("Convertendo DTO para domínio Cliente");
        Cliente cliente = convertToCliente(clienteDTO);
        ClienteDTO dto = convertToClienteDTO(clienteOutputPort.inserir(cliente));
        log.info("Cliente salvo com sucesso: {}", dto);
        return dto;
    }

    @Override
    public ClienteDTO buscarClientePorCpf(String cpf) {
        validaCpf(cpf);
        return clienteOutputPort.buscarClientePorCpf(cpf)
                .map(this::convertToClienteDTO)
                .orElseThrow(() -> new NotFoundException("Cliente com o cpf " + cpf + " não encontrado!"));
    }

    private void validaCpf(String cpf) {
        if (!ValidaCPF.isValidCPF(cpf)) {
            throw new BadRequestException("CPF " + cpf + " inválido!");
        }
    }

    private Cliente convertToCliente(ClienteDTO clienteDTO) {
        // Lógica para converter ClienteDTO em Cliente
        return new Cliente().toCliente(clienteDTO);
    }

    private ClienteDTO convertToClienteDTO(Cliente cliente) {
        // Lógica para converter Cliente em ClienteDTO
        return new ClienteDTO().toClienteDTO(cliente);
    }
}
