package br.com.postechfiap.jlapp.interfaces.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.application.domain.entities.ItemPedido;

public interface ItemPedidoOutputPort {

	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos);

	public List<ItemPedido> buscarItemPedido(Long id_pedido);

}
