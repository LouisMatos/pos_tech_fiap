package br.com.postechfiap.jlapp.domain.repositories;

import java.util.List;

import br.com.postechfiap.jlapp.domain.entities.ItemPedido;

public interface IItemPedidoRepository {

	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos);

	public List<ItemPedido> buscarItemPedido(Long idPedido);

}
