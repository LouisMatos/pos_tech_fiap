package br.com.postechfiap.jlapp.adapters.out;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.ClienteRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.ClienteEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.ports.out.ClienteOutputPort;

@Component
public class ClienteAdapter implements ClienteOutputPort {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ClienteEntityMapper clienteEntityMapper;

	@Override
	public void inserir(Cliente cliente) {
		ClienteEntity clienteEntity = clienteEntityMapper.toClienteEntity(cliente);
		clienteRepository.save(clienteEntity);
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
	public Cliente buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
