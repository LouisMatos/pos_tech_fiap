package br.com.postechfiap.jlapp.dominio.adaptadores.services;

import br.com.postechfiap.jlapp.dominio.Cliente;
import br.com.postechfiap.jlapp.dominio.dto.ClienteDTO;
import br.com.postechfiap.jlapp.dominio.portas.interfaces.ClienteServicePort;
import br.com.postechfiap.jlapp.dominio.portas.repositories.ClienteRespositoryPort;

public class ClienteServiceImp implements ClienteServicePort{
	
	private final ClienteRespositoryPort clienteRespository;

    public ClienteServiceImp(ClienteRespositoryPort clienteRespository) {
        this.clienteRespository = clienteRespository;
    }

	@Override
	public void criarCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente(clienteDTO);
        this.clienteRespository.salvar(cliente);
	}

}
