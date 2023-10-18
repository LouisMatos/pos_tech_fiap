package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.interfaces.dto.ClienteDTO;

public interface ClienteInputPort {

	public ClienteDTO inserir(ClienteDTO clienteRequest);


	public ClienteDTO buscarClientePorCpf(String cpf);

}
