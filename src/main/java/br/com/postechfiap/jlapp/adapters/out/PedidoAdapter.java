package br.com.postechfiap.jlapp.adapters.out;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.PedidoRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.PedidoEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;

@Component
public class PedidoAdapter implements PedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoEntityMapper pedidoEntityMapper;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
		return pedidoEntityMapper.toPedido(pedidoRepository.save(pedidoEntity));
	}

}
