package br.com.postechfiap.jlapp.core.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.core.entities.Pedido;

public interface PedidoOutputPort {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

	public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido);

	public Optional<Pedido> buscaPedidoNumeroPedido(String numeroPedido);

	public Pedido atualizar(Pedido pedido);

}
