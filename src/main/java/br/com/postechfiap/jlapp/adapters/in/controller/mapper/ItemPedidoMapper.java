package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ItemPedidoRequest;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;

@Mapper(componentModel = "spring", uses = ProdutoMapper.class, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemPedidoMapper {

	@Mapping(source = "produto", target = "produto.id")
//	@Mapping(source = "categoria", target = "produto.categoria.id")
	ItemPedido toItemPedido(ItemPedidoRequest itemPedidoRequest);

//	PedidoResponse toPedidoResponse(Pedido pedido);
//
//	List<PedidoResponse> toListPedidoResponse(List<Pedido> pedidos);
}
