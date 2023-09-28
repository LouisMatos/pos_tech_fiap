package br.com.postechfiap.jlapp.adapters.out;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.ClienteRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.ClienteEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.out.ClienteOutputPort;

@Component
public class ClienteAdapter implements ClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public Cliente inserir(Cliente cliente) {
		Optional<Cliente> clienteExiste = this.buscarClientePorCpf(cliente.getCpf());
		if(!clienteExiste.isEmpty()) {
			throw new UnprocessableEntityException("Cliente já cadastrado com esse CPF!");
		}
		ClienteEntity clienteEntity = clienteEntityMapper.toClienteEntity(cliente);
		return clienteEntityMapper.toCliente(clienteRepository.save(clienteEntity));
	}

	@Override
	public void atualizar(Cliente cliente) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cliente> buscar(Long id) {
		Optional<ClienteEntity> customerEntity = clienteRepository.findById(id);
		return customerEntity.map(entity -> clienteEntityMapper.toCliente(entity));
	}

	@Override
	public Optional<Cliente> buscarClientePorCpf(String cpf) {
		Optional<ClienteEntity> customerEntity = clienteRepository.findByCpf(cpf);
		return customerEntity.map(entity -> clienteEntityMapper.toCliente(entity));
	}

}
