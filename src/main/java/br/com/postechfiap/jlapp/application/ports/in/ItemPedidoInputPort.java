package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;

public interface ItemPedidoInputPort {

	public ItemPedido inserir(ItemPedido itemPedido, Long pedido_id);

}
