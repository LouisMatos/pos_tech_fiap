package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.PedidoRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.PedidoEntity;

@Component
public class PedidoAdapter implements PedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity entity = pedidoRepository.save(new PedidoEntity().toPedidoEntity(pedido));
		return pedido.toPedido(entity);
	}

	@Override
	public List<Pedido> buscarTodos() {
		List<PedidoEntity> entities = pedidoRepository.findAll();
		return entities.stream().map(entity -> new Pedido().toPedido(entity)).collect(Collectors.toList());
	}

}
