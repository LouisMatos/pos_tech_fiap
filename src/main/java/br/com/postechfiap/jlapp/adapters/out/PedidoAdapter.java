package br.com.postechfiap.jlapp.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.PedidoRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.PedidoEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PedidoAdapter implements PedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PedidoEntityMapper pedidoEntityMapper;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoEntityMapper.toPedidoEntity(pedido);
		PedidoEntity entity = pedidoRepository.save(pedidoEntity);
		log.info("Pedido Entity: {}", entity);

		return pedidoEntityMapper.toPedido(entity);
	}

	@Override
	public Optional<Pedido> buscarPedidoPorId(Long id) {
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findById(id);
		return pedidoEntity.map(entity -> pedidoEntityMapper.toPedido(entity));
	}

}