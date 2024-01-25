package br.com.postechfiap.jlapp.core.ports.in;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ClienteDTO;

public interface ClienteInputPort {

	public ClienteDTO inserir(ClienteDTO clienteRequest);


	public ClienteDTO buscarClientePorCpf(String cpf);

}
