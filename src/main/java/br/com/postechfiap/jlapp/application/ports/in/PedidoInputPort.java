package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;

public interface PedidoInputPort {

	public Pedido inserir(Pedido pedido);

	public Pedido buscarPedidoPorId(Long id);
}
