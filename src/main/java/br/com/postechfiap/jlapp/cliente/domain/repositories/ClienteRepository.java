package br.com.postechfiap.jlapp.cliente.domain.repositories;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteRequestModel;
import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;

import java.util.Optional;

public interface ClienteRepository {

	public Cliente inserir(Cliente cliente);


	public Cliente buscarClientePorCpf(String cpf);

}
