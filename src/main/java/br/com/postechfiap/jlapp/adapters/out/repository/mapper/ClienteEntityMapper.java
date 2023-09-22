package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;

@Mapper(componentModel = "spring")
public interface ClienteEntityMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    Cliente toCliente(ClienteEntity clienteEntity);

}