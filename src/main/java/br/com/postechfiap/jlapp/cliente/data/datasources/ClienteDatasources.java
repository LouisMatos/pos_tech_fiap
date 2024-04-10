package br.com.postechfiap.jlapp.cliente.data.datasources;

import java.util.Optional;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteModel;
import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;

public interface ClienteDatasources {

	public ClienteModel inserir(ClienteModel clienteModel);

	public Optional<ClienteModel> buscarClientePorCpf(String cpf);

}
