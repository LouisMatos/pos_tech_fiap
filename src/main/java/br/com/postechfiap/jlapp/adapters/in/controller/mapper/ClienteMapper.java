package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ClienteRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ClienteResponse;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.CategoriaEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;

@Mapper(componentModel = "spring", uses = CategoriaEntityMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteMapper {

	@Mapping(target = "id", ignore = true)
	Cliente toCliente(ClienteRequest clienteRequest);

	ClienteResponse toClienteResponse(Cliente cliente);

	List<ClienteResponse> toListClienteResponse(List<Cliente> cliente);

}
