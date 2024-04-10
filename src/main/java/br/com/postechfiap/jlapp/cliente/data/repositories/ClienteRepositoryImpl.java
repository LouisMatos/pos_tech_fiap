package br.com.postechfiap.jlapp.cliente.data.repositories;

import br.com.postechfiap.jlapp.categoria.data.datasources.CategoriaDatasources;
import br.com.postechfiap.jlapp.cliente.data.datasources.ClienteDatasources;
import br.com.postechfiap.jlapp.cliente.data.models.ClienteModel;
import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;
import br.com.postechfiap.jlapp.cliente.domain.repositories.ClienteRepository;
import br.com.postechfiap.jlapp.core.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import org.springframework.stereotype.Component;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {

    private final ClienteDatasources clienteDatasources;

    private final Logger log;

    public ClienteRepositoryImpl(CategoriaDatasources categoriaDatasources, ClienteDatasources clienteDatasources, Logger log) {
        this.clienteDatasources = clienteDatasources;
        this.log = log;
    }

    @Override
    public Cliente inserir(Cliente cliente) {
        ClienteModel clienteModel = new ClienteModel();
        return clienteModel.toCliente(clienteDatasources.inserir(clienteModel.toClienteModel(cliente)));
    }

    @Override
    public Cliente buscarClientePorCpf(String cpf) {
        ClienteModel clienteModel = new ClienteModel();
        return clienteModel.toCliente(clienteDatasources.buscarClientePorCpf(cpf).orElseThrow(() -> new NotFoundException("Cliente com o cpf " + cpf + " não encontrado!")));
    }
}
