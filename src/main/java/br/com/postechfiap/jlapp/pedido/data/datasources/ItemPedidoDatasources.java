package br.com.postechfiap.jlapp.pedido.data.datasources;

import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;

import java.util.List;

public interface ItemPedidoDatasources {

	public List<ItemPedidoModel> inserir(List<ItemPedidoModel> itemPedidos);

	public List<ItemPedidoModel> buscarItemPedido(Long idPedido);

}
