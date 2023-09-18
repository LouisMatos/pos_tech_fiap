package br.com.postechfiap.jlapp.infraestrutura.adaptadores.repositories;

import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.dominio.Cliente;
import br.com.postechfiap.jlapp.dominio.portas.repositories.ClienteRespositoryPort;

@Component
public class ClienteRepository implements ClienteRespositoryPort{
	
	private final SpringClienteRepository springClienteRepository;

    public ClienteRepository(SpringClienteRepository springClienteRepository) {
        this.springClienteRepository = springClienteRepository;
    }

	@Override
	public void salvar(Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

}
