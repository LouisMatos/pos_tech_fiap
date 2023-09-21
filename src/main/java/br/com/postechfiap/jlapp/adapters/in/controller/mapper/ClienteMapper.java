package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ClienteRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ClienteResponse;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteMapper {


	Cliente toCliente(ClienteRequest clienteRequest);

	ClienteResponse toClienteResponse(Cliente cliente);

	List<ClienteResponse> toListClienteResponse(List<Cliente> cliente);

}
