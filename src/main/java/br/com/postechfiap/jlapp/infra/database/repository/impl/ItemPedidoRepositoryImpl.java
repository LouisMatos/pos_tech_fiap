package br.com.postechfiap.jlapp.infra.database.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.domain.repositories.IItemPedidoRepository;
import br.com.postechfiap.jlapp.infra.database.model.ItemPedidoEntity;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class ItemPedidoRepositoryImpl implements IItemPedidoRepository {

	@Autowired
	private br.com.postechfiap.jlapp.infra.database.repository.IItemPedidoRepository IItemPedidoRepository;

	@Autowired
	private Logger log;

	@Override
	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos) {

		List<ItemPedidoEntity> list = new ArrayList<>();

		for (ItemPedido itemPedido : itemPedidos) {
			log.info("Cadastrando novo {} na base de dados!", itemPedido);
			list.add(IItemPedidoRepository.save(new ItemPedidoEntity().toItemPedidoEntity(itemPedido)));
		}

		return list.stream().map(it -> new ItemPedido().toItemPedido(it)).toList();

	}

	@Override
	public List<ItemPedido> buscarItemPedido(Long idPedido) {

		log.info("Buscando item pedido com o ID: {} na base de dados!", idPedido);
		List<ItemPedidoEntity> list = IItemPedidoRepository.findAllByPedidoid(idPedido);

		return list.stream().map(it -> new ItemPedido().toItemPedido(it)).toList();
	}

}
