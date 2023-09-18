package br.com.postechfiap.jlapp.infraestrutura.adaptadores.repositories;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.dominio.Cliente;
import br.com.postechfiap.jlapp.dominio.portas.repositories.ClienteRespositoryPort;
import br.com.postechfiap.jlapp.infraestrutura.adaptadores.entidades.ClienteEntity;

@Component
public class ClienteRepository implements ClienteRespositoryPort{
	
	private final SpringClienteRepository springClienteRepository;

    public ClienteRepository(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }

	@Override
	public void salvar(Cliente cliente) {
		ClienteEntity clienteEntity;
		 clienteEntity = new ClienteEntity(cliente);
        if (Objects.isNull(cliente.getId()))
            clienteEntity = new ClienteEntity(cliente);
        else {
//        	clienteEntity = this.springClienteRepository.findById(cliente.getId()).get();
//        	clienteEntity.atualizar(cliente);
        }

        this.springClienteRepository.save(clienteEntity);
	}

}
