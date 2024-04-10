package br.com.postechfiap.jlapp.pedido.data.datasources.impl;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.pedido.data.datasources.PedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.datasources.JpaPedidoRepository;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

@Component
public class PedidoDatasourcesImpl implements PedidoDatasources {

	private final JpaPedidoRepository jpaPedidoRepository;

	private final Logger log;

	public PedidoDatasourcesImpl(JpaPedidoRepository jpaPedidoRepository, Logger log) {
		this.jpaPedidoRepository = jpaPedidoRepository;
		this.log = log;
	}

	@Override
	public PedidoModel inserir(PedidoModel pedido) {
		log.info("Cadastrando novo pedido na base de dados!");
		return jpaPedidoRepository.save(pedido);
	}

	@Override
	public List<PedidoModel> buscarTodos() {
		log.info("Buscando todos os pedidos cadastrados na base de dados!");
		return jpaPedidoRepository.findAll();
	}

	@Override
	public Optional<PedidoModel> buscarStatusPagamentoPedido(String numero_pedido) {
		log.info("Buscando o pedido: {} na base de dados!", numero_pedido);
		return jpaPedidoRepository.findByNumeroPedido(numero_pedido);
	}

	@Override
	public Optional<PedidoModel> buscaPedidoNumeroPedido(String numero_pedido) {
		log.info("Buscando o pedido: {} na base de dados!", numero_pedido);
		return jpaPedidoRepository.findByNumeroPedido(numero_pedido);
	}

	@Override
	public PedidoModel atualizar(PedidoModel pedido) {
		log.info("Alterando pedido na base de dados!");
		return jpaPedidoRepository.save(pedido);
	}

}
