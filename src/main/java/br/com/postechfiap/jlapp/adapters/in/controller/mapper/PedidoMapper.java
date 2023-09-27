package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.postechfiap.jlapp.adapters.in.controller.request.PedidoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.PedidoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;

@Mapper(componentModel = "spring")
public interface PedidoMapper {

	
	Pedido toPedido(PedidoRequest pedidoRequest);

	PedidoResponse toPedidoResponse(Pedido pedido);

	List<PedidoResponse> toListPedidoResponse(List<Pedido> pedido);

}
