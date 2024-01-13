package br.com.postechfiap.jlapp.core.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ItemPedidoDTO;

public interface ItemPedidoInputPort {

	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> itemPedidoDTO);

	public List<ItemPedidoDTO> buscarItemPedido(Long idPedido);

}
