package br.com.postechfiap.jlapp.adapters.out;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.ItemPedidoRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ItemPedidoEntity;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;

@Component
public class ItemPedidoAdapter implements ItemPedidoOutputPort {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public List<ItemPedido> inserir(List<ItemPedido> itemPedidos) {

		List<ItemPedidoEntity> list = new ArrayList<ItemPedidoEntity>();

		for (ItemPedido itemPedido : itemPedidos) {
			list.add(itemPedidoRepository.save(new ItemPedidoEntity().toItemPedidoEntity(itemPedido)));
		}

		return list.stream().map(it -> new ItemPedido().toItemPedido(it)).collect(Collectors.toList());

	}

}
