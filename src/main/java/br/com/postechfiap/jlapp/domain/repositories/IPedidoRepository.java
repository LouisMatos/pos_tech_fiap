package br.com.postechfiap.jlapp.domain.repositories;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.domain.entities.Pedido;

public interface IPedidoRepository {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

	public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido);

	public Optional<Pedido> buscaPedidoNumeroPedido(String numeroPedido);

	public Pedido atualizar(Pedido pedido);

}
