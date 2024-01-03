package br.com.postechfiap.jlapp.application.domain.usecase;

import java.util.List;

import br.com.postechfiap.jlapp.application.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.interfaces.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.interfaces.ports.out.ItemPedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.adapters.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

public class ItemPedidoUseCase implements ItemPedidoInputPort {

	private final ItemPedidoOutputPort itemPedidoOutputPort;

	private final Logger log;

	public ItemPedidoUseCase(ItemPedidoOutputPort itemPedidoOutputPort, Logger log) {
		this.itemPedidoOutputPort = itemPedidoOutputPort;
		this.log = log;
	}

	@Override
	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> dtos) {
		log.info("Convertendo para o dominio de Item Pedido!");
		List<ItemPedido> itemPedidos = itemPedidoOutputPort
				.inserir(dtos.stream().map(it -> new ItemPedido().toItemPedido(it)).toList());

		log.info("{} salvos com sucesso!", itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).toList();
	}

	@Override
	public List<ItemPedidoDTO> buscarItemPedido(Long idPedido) {
		List<ItemPedido> itemPedidos = itemPedidoOutputPort.buscarItemPedido(idPedido);

		log.info("Itens Pedido com o pedido ID: {} encontrados {} !", idPedido, itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).toList();

	}

}