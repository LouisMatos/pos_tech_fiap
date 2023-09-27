package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;

public class PedidoUseCase implements PedidoInputPort{
	
	private final PedidoOutputPort pedidoOutputPort;
	
	public PedidoUseCase(PedidoOutputPort pedidoOutputPort) {
		this.pedidoOutputPort = pedidoOutputPort;
	}

	@Override
	public Pedido inserir(Pedido pedido) {
		return pedidoOutputPort.inserir(pedido);
	}

}
