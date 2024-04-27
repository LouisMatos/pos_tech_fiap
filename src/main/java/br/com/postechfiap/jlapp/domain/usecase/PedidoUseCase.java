package br.com.postechfiap.jlapp.domain.usecase;

import br.com.postechfiap.jlapp.domain.dtos.*;
import br.com.postechfiap.jlapp.domain.entities.Pedido;
import br.com.postechfiap.jlapp.domain.enums.Estado;
import br.com.postechfiap.jlapp.domain.enums.StatusPagamento;
import br.com.postechfiap.jlapp.domain.exceptions.NotFoundException;
import br.com.postechfiap.jlapp.domain.interfaces.ClienteInputPort;
import br.com.postechfiap.jlapp.domain.interfaces.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.domain.interfaces.PedidoInputPort;
import br.com.postechfiap.jlapp.domain.interfaces.ProdutoInputPort;
import br.com.postechfiap.jlapp.domain.repositories.IPedidoRepository;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoUseCase implements PedidoInputPort {

	private final IPedidoRepository IPedidoRepository;

	private final ClienteInputPort clienteInputPort;

	private final ProdutoInputPort produtoInputPort;

	private final ItemPedidoInputPort itemPedidoInputPort;

	private final Logger log;

	public PedidoUseCase(IPedidoRepository IPedidoRepository, ClienteInputPort clienteInputPort,
						 ProdutoInputPort produtoInputPort, ItemPedidoInputPort itemPedidoInputPort, Logger log) {
		this.IPedidoRepository = IPedidoRepository;
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
		pedidoDTO.toPedidoDTO(IPedidoRepository.inserir(new Pedido().toPedido(pedidoDTO)));

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

		pedidoDTO.toPedidoDTO(IPedidoRepository.inserir(new Pedido().toPedido(pedidoDTO)));
		log.info("{} salvo com sucesso!", pedidoDTO.toString());

		return pedidoDTO;

	}

	@Override
	public List<PedidoDTO> buscarTodos() {
		List<PedidoDTO> pedidoDTOs = IPedidoRepository.buscarTodos().stream()
				.map(pedido -> new PedidoDTO().toPedidoDTO(pedido)).toList();

		for (int i = 0; i < pedidoDTOs.size(); i++) {
			pedidoDTOs.get(i).setItemPedidoDTOs(itemPedidoInputPort.buscarItemPedido(pedidoDTOs.get(i).getId()));
		}

		log.info("Pedidos encontrados! {}", pedidoDTOs);
		return pedidoDTOs;
	}

	@Override
	public StatusPedidoDTO buscarStatusPagamentoPedido(String numero_pedido) {

		PedidoDTO dto = new PedidoDTO().toPedidoDTO(IPedidoRepository.buscarStatusPagamentoPedido(numero_pedido)
				.orElseThrow(() -> new NotFoundException("Pedido: " + numero_pedido + " não foi encontrado!")));

		log.info("Pedido encontrado! {}", dto);

		return StatusPedidoDTO.builder().numeroPedido(dto.getNumeroPedido()).statusPagamento(dto.getStatusPagamento())
				.build();
	}

	@Override
	public PedidoDTO buscaPedidoNumeroPedido(String numeroPedido) {
		PedidoDTO dto = new PedidoDTO().toPedidoDTO(IPedidoRepository.buscaPedidoNumeroPedido(numeroPedido)
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

		PedidoDTO dto = new PedidoDTO().toPedidoDTO(IPedidoRepository.atualizar(pedido));
		log.info("{} alterado com sucesso!", dto.toString());

		return dto;

	}

	@Override
	public List<PedidoAcompanhamentoDTO> buscarPedidosAcompanhamento() {

		List<PedidoDTO> pedidoDTOs = IPedidoRepository.buscarTodos().stream()
				.map(pedido -> new PedidoDTO().toPedidoDTO(pedido)).toList();

		List<PedidoAcompanhamentoDTO> lista = pedidoDTOs.stream()
				.map(pedido -> new PedidoAcompanhamentoDTO().toPedidoAcompanhamento(pedido))
				.collect((Collectors.toList()));
		log.info("Convertendo para o dominio de Acompanhamento de pedido!");

		lista.removeIf(t -> t.getEstado().estaFinalizado());
		log.info("Removendo os pedido em Estdo: Finalizado");

		lista.sort(Comparator.comparing(PedidoAcompanhamentoDTO::getEstado).reversed()
				.thenComparing(t -> t.getDataPedido()));
		log.info(
				"Ordenando pedidos na seguinte ordem [Pronto > Em Preparação > Recebido] sendo pedidos mais antigos primeiro que os mais novos");

		return lista;
	}
	
	@Override
	public StatusPedidoTesteDTO atualizaStatusPedidoTeste(StatusPedidoTesteDTO statusPedidoTesteDTO) {

		log.info("Convertendo para o dominio de Pedido!");
		Pedido pedido = new Pedido().toPedido(this.buscaPedidoNumeroPedido(statusPedidoTesteDTO.getNumeroPedido()));

		log.info("Atualizando o pedido de numero: {} !", statusPedidoTesteDTO.getNumeroPedido());
		pedido.setEstado(statusPedidoTesteDTO.getEstado());

		PedidoDTO dto = new PedidoDTO().toPedidoDTO(IPedidoRepository.atualizar(pedido));
		log.info("{} alterado com sucesso!", dto.toString());

		return statusPedidoTesteDTO;
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

		if (!IPedidoRepository.buscarStatusPagamentoPedido(numeroPedido).isEmpty()) {
			log.info("Numero de Pedido: {} já existe gerando novo numero", numeroPedido);
			gerarNumeroPedido();
		} else {
			log.info("Numero de Pedido: {} disponivel para ser utilizado!", numeroPedido);
		}

		return numeroPedido;
	}

	

}
