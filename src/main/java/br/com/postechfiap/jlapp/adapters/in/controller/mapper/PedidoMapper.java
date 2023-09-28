package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.in.controller.request.PedidoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.PedidoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;

@Mapper(componentModel = "spring", uses = ItemPedidoMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PedidoMapper {

	@Mapping(target = "id", ignore = true)
	Pedido toPedido(PedidoRequest pedidoRequest);

	PedidoResponse toPedidoResponse(Pedido pedido);

	List<PedidoResponse> toListPedidoResponse(List<Pedido> pedidos);

}
