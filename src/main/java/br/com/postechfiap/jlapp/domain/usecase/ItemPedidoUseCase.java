package br.com.postechfiap.jlapp.domain.usecase;

import br.com.postechfiap.jlapp.domain.dtos.ItemPedidoDTO;
import br.com.postechfiap.jlapp.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.domain.interfaces.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.domain.repositories.IItemPedidoRepository;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

import java.util.List;

public class ItemPedidoUseCase implements ItemPedidoInputPort {

	private final IItemPedidoRepository IItemPedidoRepository;

	private final Logger log;

	public ItemPedidoUseCase(IItemPedidoRepository IItemPedidoRepository, Logger log) {
		this.IItemPedidoRepository = IItemPedidoRepository;
		this.log = log;
	}

	@Override
	public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> dtos) {
		log.info("Convertendo para o dominio de Item Pedido!");
		List<ItemPedido> itemPedidos = IItemPedidoRepository
				.inserir(dtos.stream().map(it -> new ItemPedido().toItemPedido(it)).toList());

		log.info("{} salvos com sucesso!", itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).toList();
	}

	@Override
	public List<ItemPedidoDTO> buscarItemPedido(Long idPedido) {
		List<ItemPedido> itemPedidos = IItemPedidoRepository.buscarItemPedido(idPedido);

		log.info("Itens Pedido com o pedido ID: {} encontrados {} !", idPedido, itemPedidos);
		return itemPedidos.stream().map(it -> new ItemPedidoDTO().toItemPedidoDTO(it)).toList();

	}

}
