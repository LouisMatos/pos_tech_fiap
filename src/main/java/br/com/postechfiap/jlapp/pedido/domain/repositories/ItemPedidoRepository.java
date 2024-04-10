package br.com.postechfiap.jlapp.pedido.domain.repositories;

import java.util.List;

import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoRequestModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;

public interface ItemPedidoRepository {

	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos);

	public List<ItemPedido> buscarItemPedido(Long idPedido);

}
