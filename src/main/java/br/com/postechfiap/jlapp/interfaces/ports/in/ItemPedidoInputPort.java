package br.com.postechfiap.jlapp.interfaces.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.interfaces.dto.ItemPedidoDTO;

public interface ItemPedidoInputPort {

	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> itemPedidoDTO);

	public List<ItemPedidoDTO> buscarItemPedido(Long id_pedido);

}
