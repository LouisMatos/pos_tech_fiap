package br.com.postechfiap.jlapp.infra.database.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.Pedido;
import br.com.postechfiap.jlapp.infra.database.repository.IPedidoRepository;
import br.com.postechfiap.jlapp.infra.database.model.PedidoEntity;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class PedidoRespositoryImpl implements br.com.postechfiap.jlapp.domain.repositories.IPedidoRepository {

	@Autowired
	private IPedidoRepository IPedidoRepository;

	@Autowired
	private Logger log;

	@Override
	public Pedido inserir(Pedido pedido) {
		PedidoEntity pedidoEntity = IPedidoRepository.save(new PedidoEntity().toPedidoEntity(pedido));
		log.info("Cadastrando novo pedido na base de dados!");
		return pedido.toPedido(pedidoEntity);
	}

	@Override
	public List<Pedido> buscarTodos() {
		log.info("Buscando todos os pedidos cadastrados na base de dados!");
		List<PedidoEntity> pedidoEntities = IPedidoRepository.findAll();
		return pedidoEntities.stream().map(pedidoEntity -> new Pedido().toPedido(pedidoEntity)).toList();
	}

	@Override
	public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido) {
		log.info("Buscando o pedido: {} na base de dados!", numero_pedido);
		Optional<PedidoEntity> pedidoEntity = IPedidoRepository.findByNumeroPedido(numero_pedido);
		return pedidoEntity.map(entity -> new Pedido().toPedido(entity));
	}

	@Override
	public Optional<Pedido> buscaPedidoNumeroPedido(String numero_pedido) {
		log.info("Buscando o pedido: {} na base de dados!", numero_pedido);
		Optional<PedidoEntity> pedidoEntity = IPedidoRepository.findByNumeroPedido(numero_pedido);
		return pedidoEntity.map(entity -> new Pedido().toPedido(entity));
	}

	@Override
	public Pedido atualizar(Pedido pedido) {
		PedidoEntity pedidoEntity = new PedidoEntity().toPedidoEntity(pedido);
		log.info("Alterando pedido na base de dados!");
		return pedido.toPedido(IPedidoRepository.save(pedidoEntity));
	}

}
