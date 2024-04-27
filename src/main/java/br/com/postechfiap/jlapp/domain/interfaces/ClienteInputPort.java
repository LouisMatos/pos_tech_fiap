package br.com.postechfiap.jlapp.domain.interfaces;

import br.com.postechfiap.jlapp.domain.dtos.ClienteDTO;

public interface ClienteInputPort {

	public ClienteDTO inserir(ClienteDTO clienteRequest);


	public ClienteDTO buscarClientePorCpf(String cpf);

}
