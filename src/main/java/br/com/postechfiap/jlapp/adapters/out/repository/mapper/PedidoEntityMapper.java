package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;

@Mapper(componentModel = "spring", uses = { ItemPedidoEntityMapper.class, ClienteEntityMapper.class, CategoriaEntityMapper.class})
public interface PedidoEntityMapper {

	PedidoEntityMapper INSTANCE = Mappers.getMapper(PedidoEntityMapper.class);

	@Mapping(source = "itens", target = "itensPedidoEntities")
	@Mapping(source = "cliente", target = "clienteEntity")
	PedidoEntity toPedidoEntity(Pedido pedido);

	@InheritInverseConfiguration
	@Mapping(source = "itensPedidoEntities", target = "itens")
	@Mapping(source = "clienteEntity", target = "cliente")
	Pedido toPedido(PedidoEntity pedidoEntity);

}