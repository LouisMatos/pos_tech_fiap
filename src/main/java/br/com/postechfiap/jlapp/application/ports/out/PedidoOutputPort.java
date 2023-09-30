package br.com.postechfiap.jlapp.application.ports.out;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;

public interface PedidoOutputPort {
	
	public Pedido inserir(Pedido pedido);

}
