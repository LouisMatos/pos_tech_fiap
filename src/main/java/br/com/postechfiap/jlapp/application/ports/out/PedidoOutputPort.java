package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;

public interface PedidoOutputPort {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

}
