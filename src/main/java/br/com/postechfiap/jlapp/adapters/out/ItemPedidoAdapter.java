package br.com.postechfiap.jlapp.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.ItemPedidoRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ItemPedidoEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.ItemPedidoEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;
import lombok.extern.slf4j.Slf4j;


@Component
public class ItemPedidoAdapter implements ItemPedidoOutputPort {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ItemPedidoEntityMapper itemPedidoEntityMapper;

	@Override
	public ItemPedido inserir(ItemPedido itemPedido) {

		ItemPedidoEntity itemPedidoEntity = itemPedidoEntityMapper.toItemPedidoEntity(itemPedido);

		ItemPedidoEntity save = itemPedidoRepository.save(itemPedidoEntity);

		return itemPedidoEntityMapper.toItemPedido(save);
	}

}