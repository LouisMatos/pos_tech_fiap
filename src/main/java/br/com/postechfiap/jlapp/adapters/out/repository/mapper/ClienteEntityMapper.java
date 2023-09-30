package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ClienteEntity;
import br.com.postechfiap.jlapp.application.core.domain.Cliente;

@Mapper(componentModel = "spring", uses = { ProdutoEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClienteEntityMapper {

    ClienteEntity toClienteEntity(Cliente cliente);

    @Mapping(source = "pedidosEntities", target = "pedidos")
    Cliente toCliente(ClienteEntity clienteEntity);

}