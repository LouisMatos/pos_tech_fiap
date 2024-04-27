package br.com.postechfiap.jlapp.domain.interfaces;

import java.util.List;

import br.com.postechfiap.jlapp.domain.dtos.ItemPedidoDTO;

public interface ItemPedidoInputPort {

	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> itemPedidoDTO);

	public List<ItemPedidoDTO> buscarItemPedido(Long idPedido);

}
