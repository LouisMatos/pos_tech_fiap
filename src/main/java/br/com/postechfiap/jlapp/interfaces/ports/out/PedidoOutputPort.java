package br.com.postechfiap.jlapp.interfaces.ports.out;

import java.util.List;

import br.com.postechfiap.jlapp.application.domain.entities.Pedido;

public interface PedidoOutputPort {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

}
