package br.com.postechfiap.jlapp.infrastructure.gateway;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.core.entities.Cliente;
import br.com.postechfiap.jlapp.core.ports.out.ClienteOutputPort;
import br.com.postechfiap.jlapp.infrastructure.persistence.ClienteRepository;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.ClienteEntity;
import br.com.postechfiap.jlapp.shared.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class ClienteAdapter implements ClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;

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
		return cliente.toCliente(clienteRepository.save(clienteEntity));
	}

	@Override
	public Optional<Cliente> buscarClientePorCpf(String cpf) {
		log.info("Buscando cliente com o cpf {} na base de dados!", cpf);
		Optional<ClienteEntity> customerEntity = clienteRepository.findByCpf(cpf);
		return customerEntity.map(entity -> new Cliente().toCliente(entity));
	}

}
