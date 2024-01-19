package br.com.postechfiap.jlapp.core.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.RandomStringUtils;

import br.com.postechfiap.jlapp.core.entities.Pedido;
import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.core.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.core.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.core.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.core.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.core.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.PedidoAcompanhamentoDTO;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.PedidoDTO;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.StatusPedidoDTO;
import br.com.postechfiap.jlapp.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

public class PedidoUseCase implements PedidoInputPort {

	private final PedidoOutputPort pedidoOutputPort;

	private final ClienteInputPort clienteInputPort;

	private final ProdutoInputPort produtoInputPort;

	private final ItemPedidoInputPort itemPedidoInputPort;

	private final Logger log;

	public PedidoUseCase(PedidoOutputPort pedidoOutputPort, ClienteInputPort clienteInputPort,
			ProdutoInputPort produtoInputPort, ItemPedidoInputPort itemPedidoInputPort, Logger log) {
		this.pedidoOutputPort = pedidoOutputPort;
		this.clienteInputPort = clienteInputPort;
		this.produtoInputPort = produtoInputPort;
		this.itemPedidoInputPort = itemPedidoInputPort;
		this.log = log;
	}

	@Override
	public PedidoDTO inserir(PedidoDTO pedidoDTO) {

		log.info("Verificando se o cliente se indentificou!");
		if (!pedidoDTO.getClienteDTO().getCpf().isBlank()) {
			pedidoDTO.setClienteDTO(clienteInputPort.buscarClientePorCpf(pedidoDTO.getClienteDTO().getCpf()));
		} else {
			pedidoDTO.setClienteDTO(null);
			log.info("Pedido sem identificação do cliente!");
		}

		pedidoDTO.setEstado(Estado.RECEBIDO);
		pedidoDTO.setStatusPagamento(StatusPagamento.AGUARDANDO);
		pedidoDTO.setDataPedido(LocalDateTime.now());

		log.info("Convertendo para o dominio de Pedido!");
		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));

		log.info("Processando itens do pedido!");
		for (int i = 0; i < pedidoDTO.getItemPedidoDTOs().size(); i++) {
			pedidoDTO.getItemPedidoDTOs().get(i).setProdutoDTO(
					produtoInputPort.buscarProdutoPorId(pedidoDTO.getItemPedidoDTOs().get(i).getProdutoDTO().getId()));
			pedidoDTO.getItemPedidoDTOs().get(i).setPedidoid(pedidoDTO.getId());
		}

		log.info("Incluindo itens ao pedido!");
		pedidoDTO.setItemPedidoDTOs(itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs()));

		log.info("Calculando o valor do Pedido!");
		pedidoDTO.setValorPedido(calcularValorTotalPedido(pedidoDTO.getItemPedidoDTOs()));

		log.info("Gerando numero de pedido!");
		pedidoDTO.setNumeroPedido(gerarNumeroPedido());

		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));
		log.info("{} salvo com sucesso!", pedidoDTO.toString());

		return pedidoDTO;

	}

	@Override
	public List<PedidoDTO> buscarTodos() {
		List<PedidoDTO> pedidoDTOs = pedidoOutputPort.buscarTodos().stream()
				.map(pedido -> new PedidoDTO().toPedidoDTO(pedido)).toList();

		for (int i = 0; i < pedidoDTOs.size(); i++) {
			pedidoDTOs.get(i).setItemPedidoDTOs(itemPedidoInputPort.buscarItemPedido(pedidoDTOs.get(i).getId()));
		}

		log.info("Pedidos encontrados! {}", pedidoDTOs);
		return pedidoDTOs;
	}

	@Override
	public StatusPedidoDTO buscarStatusPagamentoPedido(String numero_pedido) {

		PedidoDTO dto = new PedidoDTO().toPedidoDTO(pedidoOutputPort.buscarStatusPagamentoPedido(numero_pedido)
				.orElseThrow(() -> new NotFoundException("Pedido: " + numero_pedido + " não foi encontrado!")));

		log.info("Pedido encontrado! {}", dto);

		return StatusPedidoDTO.builder().numeroPedido(dto.getNumeroPedido()).statusPagamento(dto.getStatusPagamento())
				.build();
	}

	@Override
	public PedidoDTO buscaPedidoNumeroPedido(String numeroPedido) {
		PedidoDTO dto = new PedidoDTO().toPedidoDTO(pedidoOutputPort.buscaPedidoNumeroPedido(numeroPedido)
				.orElseThrow(() -> new NotFoundException("Pedido numero " + numeroPedido + " não encontrado!")));
		log.info("Pedido: {} encontrado com sucesso!", numeroPedido);
		return dto;
	}

	@Override
	public PedidoDTO atualizar(PedidoDTO pedidoDTO, String numeroPedido) {
		this.buscaPedidoNumeroPedido(numeroPedido);

		log.info("Convertendo para o dominio de Pedido!");
		Pedido pedido = new Pedido().toPedido(pedidoDTO);

		log.info("Atualizando o pedido de numero: {} !", numeroPedido);
		pedido.setNumeroPedido(numeroPedido);

		PedidoDTO dto = new PedidoDTO().toPedidoDTO(pedidoOutputPort.atualizar(pedido));
		log.info("{} alterado com sucesso!", dto.toString());

		return dto;

	}

	@Override
	public List<PedidoAcompanhamentoDTO> buscarPedidosAcompanhamento() {

		List<PedidoDTO> pedidoDTOs = pedidoOutputPort.buscarTodos().stream()
				.map(pedido -> new PedidoDTO().toPedidoDTO(pedido)).toList();

		log.info("Convertendo para o dominio de Acompanhamento de pedido!");
		List<PedidoAcompanhamentoDTO> lista = pedidoDTOs.stream()
				.map(pedido -> new PedidoAcompanhamentoDTO().toPedidoAcompanhamento(pedido))
				.collect((Collectors.toList()));

		log.info("Removendo os pedido em Estdo: Finalizado");
		lista.removeIf(t -> t.getEstado().estaFinalizado());

		log.info(
				"Ordenando pedidos na seguinte ordem [Pronto > Em Preparação > Recebido] sendo pedidos mais antigos primeiro que os mais novos");
		lista.sort(Comparator.comparing(PedidoAcompanhamentoDTO::getEstado).reversed()
				.thenComparing(t -> t.getDataPedido()));

		return lista;
	}

	private BigDecimal calcularValorTotalPedido(List<ItemPedidoDTO> itemPedidoDTOs) {
		BigDecimal valorPedido = BigDecimal.ZERO;

		for (ItemPedidoDTO itemPedidoDTO : itemPedidoDTOs) {
			valorPedido = valorPedido.add(
					itemPedidoDTO.getProdutoDTO().getPreco().multiply(new BigDecimal(itemPedidoDTO.getQuantidade())));
		}

		log.info("Valor do Pedido: R$ {}", valorPedido);
		return valorPedido;
	}

	private String gerarNumeroPedido() {
		String numeroPedido = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
		log.info("Numero de Pedido: {}", numeroPedido);

		if (!pedidoOutputPort.buscarStatusPagamentoPedido(numeroPedido).isEmpty()) {
			log.info("Numero de Pedido: {} já existe gerando novo numero", numeroPedido);
			gerarNumeroPedido();
		} else {
			log.info("Numero de Pedido: {} disponivel para ser utilizado!", numeroPedido);
		}

		return numeroPedido;
	}

}
