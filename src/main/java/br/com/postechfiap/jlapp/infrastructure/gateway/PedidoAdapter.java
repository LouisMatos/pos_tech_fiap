package br.com.postechfiap.jlapp.infrastructure.gateway;

import java.util.List;

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
		PedidoEntity entity = pedidoRepository.save(new PedidoEntity().toPedidoEntity(pedido));
		log.info("Cadastrando novo pedido na base de dados!");
		return pedido.toPedido(entity);
	}

	@Override
	public List<Pedido> buscarTodos() {
		log.info("Buscando todos os pedidos cadastrados na base de dados!");
		List<PedidoEntity> entities = pedidoRepository.findAll();
		return entities.stream().map(entity -> new Pedido().toPedido(entity)).toList();
	}

}
