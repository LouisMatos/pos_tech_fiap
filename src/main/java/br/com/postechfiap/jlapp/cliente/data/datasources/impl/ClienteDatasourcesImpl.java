package br.com.postechfiap.jlapp.cliente.data.datasources.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.cliente.data.datasources.ClienteDatasources;
import br.com.postechfiap.jlapp.cliente.data.datasources.JpaClienteRepository;
import br.com.postechfiap.jlapp.cliente.data.models.ClienteModel;
import br.com.postechfiap.jlapp.core.shared.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

@Component
public class ClienteDatasourcesImpl implements ClienteDatasources {

    private final JpaClienteRepository jpaClienteRepository;

    private final Logger log;

    public ClienteDatasourcesImpl(JpaClienteRepository jpaClienteRepository, Logger log) {
        this.jpaClienteRepository = jpaClienteRepository;
        this.log = log;
    }

    @Override
    public ClienteModel inserir(ClienteModel clienteModel) {

        log.info("Verificando se o cliente já existe na base!");

        Optional<ClienteModel> clienteExiste = this.buscarClientePorCpf(clienteModel.getCpf());
        if (!clienteExiste.isEmpty()) {
            throw new UnprocessableEntityException("Já existe um cliente cadastrado para o cpf: " + clienteModel.getCpf());
        }

        log.info("Cadastrando novo cliente!");
        return jpaClienteRepository.save(clienteModel);
    }

    @Override
    public Optional<ClienteModel> buscarClientePorCpf(String cpf) {
        log.info("Buscando cliente com o cpf {} na base de dados!", cpf);
        return jpaClienteRepository.findByCpf(cpf);
    }

}
