package br.com.postechfiap.jlapp.application.core.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.PedidoDTO;

public class PedidoUseCase implements PedidoInputPort {

	private final PedidoOutputPort pedidoOutputPort;

	private final ClienteInputPort clienteInputPort;

	private final ProdutoInputPort produtoInputPort;

	private final ItemPedidoInputPort itemPedidoInputPort;

	public PedidoUseCase(PedidoOutputPort pedidoOutputPort, ClienteInputPort clienteInputPort,
			ProdutoInputPort produtoInputPort, ItemPedidoInputPort itemPedidoInputPort) {
		this.pedidoOutputPort = pedidoOutputPort;
		this.clienteInputPort = clienteInputPort;
		this.produtoInputPort = produtoInputPort;
		this.itemPedidoInputPort = itemPedidoInputPort;
	}

	@Override
	public PedidoDTO inserir(PedidoDTO pedidoDTO) {

		if (!pedidoDTO.getClienteDTO().getCpf().isBlank()) {
			pedidoDTO.setClienteDTO(clienteInputPort.buscarClientePorCpf(pedidoDTO.getClienteDTO().getCpf()));
		}

		pedidoDTO.setEstado(Estado.RECEBIDO);
		pedidoDTO.setData_pedido(LocalDateTime.now());

		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));

		for (int i = 0; i < pedidoDTO.getItemPedidoDTOs().size(); i++) {
			pedidoDTO.getItemPedidoDTOs().get(i).setProdutoDTO(
					produtoInputPort.buscarProdutoPorId(pedidoDTO.getItemPedidoDTOs().get(i).getProdutoDTO().getId()));
			pedidoDTO.getItemPedidoDTOs().get(i).setId_pedido(pedidoDTO.getId());

		}

		pedidoDTO.setItemPedidoDTOs(itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs()));

		pedidoDTO.setValor_pedido(calcularValorTotalPedido(pedidoDTO.getItemPedidoDTOs()));

		pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));

		return pedidoDTO;

	}

	private BigDecimal calcularValorTotalPedido(List<ItemPedidoDTO> itemPedidoDTOs) {
		BigDecimal valorPedido = BigDecimal.ZERO;

		for (ItemPedidoDTO itemPedidoDTO : itemPedidoDTOs) {
			valorPedido = valorPedido.add(
					itemPedidoDTO.getProdutoDTO().getPreco().multiply(new BigDecimal(itemPedidoDTO.getQuantidade())));
		}
		return valorPedido;
	}

}
