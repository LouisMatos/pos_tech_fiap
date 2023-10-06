package br.com.postechfiap.jlapp.infrastructure.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.PedidoRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.entity.PedidoEntity;

@Component
public class PedidoAdapter implements PedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity entity = pedidoRepository.save(new PedidoEntity().toPedidoEntity(pedido));
		return pedido.toPedido(entity);
	}

}
