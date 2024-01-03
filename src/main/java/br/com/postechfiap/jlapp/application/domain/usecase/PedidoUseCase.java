package br.com.postechfiap.jlapp.application.domain.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.postechfiap.jlapp.application.domain.entities.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.interfaces.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.interfaces.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.interfaces.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.interfaces.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.interfaces.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.adapters.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.interfaces.adapters.dto.PedidoDTO;
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

	private BigDecimal calcularValorTotalPedido(List<ItemPedidoDTO> itemPedidoDTOs) {
		BigDecimal valorPedido = BigDecimal.ZERO;

		for (ItemPedidoDTO itemPedidoDTO : itemPedidoDTOs) {
			valorPedido = valorPedido.add(
					itemPedidoDTO.getProdutoDTO().getPreco().multiply(new BigDecimal(itemPedidoDTO.getQuantidade())));
		}

		log.info("Valor do Pedido: R$ {}", valorPedido);
		return valorPedido;
	}

}