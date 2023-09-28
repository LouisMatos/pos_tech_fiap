package br.com.postechfiap.jlapp.application.core.usecase;

import java.math.BigDecimal;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PedidoUseCase implements PedidoInputPort {

	private final PedidoOutputPort pedidoOutputPort;

	private final ClienteInputPort clienteInputPort;

	private final ProdutoInputPort produtoInputPort;

	private final CategoriaInputPort categoriaInputPort;

	public PedidoUseCase(PedidoOutputPort pedidoOutputPort, ClienteInputPort clienteInputPort,
			ProdutoInputPort produtoInputPort, CategoriaInputPort categoriaInputPort) {
		this.pedidoOutputPort = pedidoOutputPort;
		this.clienteInputPort = clienteInputPort;
		this.produtoInputPort = produtoInputPort;
		this.categoriaInputPort = categoriaInputPort;
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
			// itemPedido.getProduto().setCategoria(categoriaInputPort.buscarCategoriaPorId(produtoInputPort.buscarProdutoPorId(itemPedido.getProduto().getId()).getCategoria().getId()));
//			itemPedido.getProduto().setCategoria(null);

			valorPedido = valorPedido.add(itemPedido.getProduto().getPreco());
		}

		log.info(pedido.getItens().get(1).getProduto().toString());

		pedido.setEstado(Estado.RECEBIDO);
		pedido.setValor_pedido(valorPedido);

		log.info(pedido.toString());

		return pedidoOutputPort.inserir(pedido);
	}

}
