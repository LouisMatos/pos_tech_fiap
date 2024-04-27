package br.com.postechfiap.jlapp.infra.database.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.Cliente;
import br.com.postechfiap.jlapp.infra.database.repository.IClienteRepository;
import br.com.postechfiap.jlapp.infra.database.model.ClienteEntity;
import br.com.postechfiap.jlapp.domain.exceptions.UnprocessableEntityException;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class ClienteRepositoryImpl implements br.com.postechfiap.jlapp.domain.repositories.IClienteRepository {

	@Autowired
	private IClienteRepository IClienteRepository;

	@Autowired
	private Logger log;

	@Override
	public Cliente inserir(Cliente cliente) {

		log.info("Verificando se o cliente já existe na base!");

		Optional<Cliente> clienteExiste = this.buscarClientePorCpf(cliente.getCpf());
		if (!clienteExiste.isEmpty()) {
			throw new UnprocessableEntityException("Já existe um cliente cadastrado para o cpf: " + cliente.getCpf());
		}

		log.info("Cadastrando novo cliente!");
		ClienteEntity clienteEntity = new ClienteEntity().toClienteEntity(cliente);
		return cliente.toCliente(IClienteRepository.save(clienteEntity));
	}

	@Override
	public Optional<Cliente> buscarClientePorCpf(String cpf) {
		log.info("Buscando cliente com o cpf {} na base de dados!", cpf);
		Optional<ClienteEntity> customerEntity = IClienteRepository.findByCpf(cpf);
		return customerEntity.map(entity -> new Cliente().toCliente(entity));
	}

}
