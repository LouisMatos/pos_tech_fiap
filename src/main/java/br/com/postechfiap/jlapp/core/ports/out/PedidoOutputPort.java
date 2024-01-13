package br.com.postechfiap.jlapp.core.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.core.entities.Pedido;

public interface PedidoOutputPort {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

}
