package br.com.postechfiap.jlapp.application.core.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public Pedido inserir(Pedido pedido) {

		BigDecimal valorPedido = BigDecimal.ZERO;
		;

		if (!pedido.getCliente().getCpf().isBlank()) {
			pedido.setCliente(clienteInputPort.buscarClientePorCpf(pedido.getCliente().getCpf()));
		}

		for (ItemPedido itemPedido : pedido.getItens()) {
			itemPedido.setProduto(produtoInputPort.buscarProdutoPorId(itemPedido.getProduto().getId()));
			valorPedido = valorPedido.add(itemPedido.getProduto().getPreco());
		}

		log.info(pedido.getItens().get(1).getProduto().toString());

		pedido.setEstado(Estado.RECEBIDO);
		pedido.setValor_pedido(valorPedido);
		pedido.setData_pedido(LocalDateTime.now());

		log.info(pedido.toString());

		Pedido pedidoSalvo = pedidoOutputPort.inserir(pedido);

		for (ItemPedido itensPedido : pedidoSalvo.getItens()) {

			itemPedidoInputPort.inserir(itensPedido, pedidoSalvo.getId());

//			System.out.println(pedidoSalvo.getItens());
//			itensPedido.getPedido().setId(pedidoSalvo.getId());
//			
//			System.out.println(itensPedido.toString());
		}

		return pedidoOutputPort.inserir(pedido);
	}

	@Override
	public Pedido buscarPedidoPorId(Long id) {
		return pedidoOutputPort.buscarPedidoPorId(id)
				.orElseThrow(() -> new NotFoundException("Pedido Não encontrado!"));
	}

}
