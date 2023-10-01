package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;

public class ItemPedidoUseCase implements ItemPedidoInputPort {

	private final ItemPedidoOutputPort itemPedidoOutputPort;

	private final PedidoInputPort pedidoInputPort;

	public ItemPedidoUseCase(ItemPedidoOutputPort itemPedidoOutputPort, PedidoInputPort pedidoInputPort) {
		this.itemPedidoOutputPort = itemPedidoOutputPort;
		this.pedidoInputPort = pedidoInputPort;
	}

	@Override
	public ItemPedido inserir(ItemPedido itemPedido, Long pedido_id) {

		Pedido pedido = pedidoInputPort.buscarPedidoPorId(pedido_id);

		itemPedido.setPedido(pedido);

		return itemPedidoOutputPort.inserir(itemPedido);
	}

}
