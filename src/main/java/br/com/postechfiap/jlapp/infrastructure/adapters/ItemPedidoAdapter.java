package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.interfaces.ports.out.ItemPedidoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.ItemPedidoRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.ItemPedidoEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class ItemPedidoAdapter implements ItemPedidoOutputPort {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private Logger log;

	@Override
	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos) {

		List<ItemPedidoEntity> list = new ArrayList<>();

		for (ItemPedido itemPedido : itemPedidos) {
			log.info("Cadastrando novo {} na base de dados!", itemPedido);
			list.add(itemPedidoRepository.save(new ItemPedidoEntity().toItemPedidoEntity(itemPedido)));
		}

		return list.stream().map(it -> new ItemPedido().toItemPedido(it)).toList();

	}

	@Override
	public List<ItemPedido> buscarItemPedido(Long idPedido) {

		log.info("Buscando item pedido com o ID: {} na base de dados!", idPedido);
		List<ItemPedidoEntity> list = itemPedidoRepository.findAllByPedidoid(idPedido);

		return list.stream().map(it -> new ItemPedido().toItemPedido(it)).toList();
	}

}