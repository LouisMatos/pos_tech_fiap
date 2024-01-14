package br.com.postechfiap.jlapp.infrastructure.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.core.entities.Pedido;
import br.com.postechfiap.jlapp.core.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.persistence.PedidoRepository;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.PedidoEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class PedidoAdapter implements PedidoOutputPort {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private Logger log;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity pedidoEntity = pedidoRepository.save(new PedidoEntity().toPedidoEntity(pedido));
		log.info("Cadastrando novo pedido na base de dados!");
		return pedido.toPedido(pedidoEntity);
	}

	@Override
	public List<Pedido> buscarTodos() {
		log.info("Buscando todos os pedidos cadastrados na base de dados!");
		List<PedidoEntity> pedidoEntities = pedidoRepository.findAll();
		return pedidoEntities.stream().map(pedidoEntity -> new Pedido().toPedido(pedidoEntity)).toList();
	}

	@Override
	public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido) {
		log.info("Buscando o pedido: {} na base de dados!", numero_pedido);
		Optional<PedidoEntity> pedidoEntity = pedidoRepository.findByNumeroPedido(numero_pedido);
		return pedidoEntity.map(entity -> new Pedido().toPedido(entity)) ;
	}

}
