package br.com.postechfiap.jlapp.core.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.core.entities.ItemPedido;

public interface ItemPedidoOutputPort {

	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos);

	public List<ItemPedido> buscarItemPedido(Long idPedido);

}
