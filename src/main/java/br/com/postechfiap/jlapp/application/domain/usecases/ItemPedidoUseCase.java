package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ItemPedidoDTO;
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
				.inserir(dtos.stream().map(it -> new ItemPedido().toItemPedido(it)).collect(Collectors.toList()));

		log.info("{} salvos com sucesso!", itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).collect(Collectors.toList());
	}

	@Override
	public List<ItemPedidoDTO> buscarItemPedido(Long id_pedido) {
		List<ItemPedido> itemPedidos = itemPedidoOutputPort.buscarItemPedido(id_pedido);

		log.info("Itens Pedido com o pedido ID: {} encontrados {} !", id_pedido, itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).collect(Collectors.toList());

	}

}
