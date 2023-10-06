package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;

public interface ItemPedidoOutputPort {

	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos);

}
