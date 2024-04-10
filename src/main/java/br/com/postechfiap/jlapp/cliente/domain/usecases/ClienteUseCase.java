package br.com.postechfiap.jlapp.cliente.domain.usecases;

import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;
import br.com.postechfiap.jlapp.cliente.domain.repositories.ClienteRepository;
import br.com.postechfiap.jlapp.core.shared.exception.BadRequestException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.core.shared.utils.ValidaCPF;

public class ClienteUseCase {

    private final ClienteRepository clienteRepository;
    private final Logger log;

    public ClienteUseCase(ClienteRepository clienteRepository, Logger log) {
        this.clienteRepository = clienteRepository;
        this.log = log;
    }

    public Cliente inserir(Cliente cliente) {

        validaCpf(cliente.getCpf());

        Cliente clienteCadastrado = clienteRepository.inserir(cliente);
        log.info("{} salvo com sucesso!", clienteCadastrado.toString());

        return clienteCadastrado;
    }

    public Cliente buscarClientePorCpf(String cpf) {

        validaCpf(cpf);

        Cliente cliente = clienteRepository.buscarClientePorCpf(cpf);
        log.info("Cliente com o cpf {} encontrado!", cpf);

        return cliente;
    }

    private void validaCpf(String cpf) {
        if (!ValidaCPF.isValidCPF(cpf)) {
            throw new BadRequestException("CPF " + cpf + " não é valido!");
        }
    }

}
