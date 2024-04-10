package br.com.postechfiap.jlapp.pedido.data.datasources;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;

public interface PedidoDatasources {

	public PedidoModel inserir(PedidoModel pedido);

	public List<PedidoModel> buscarTodos();

	public Optional<PedidoModel> buscarStatusPagamentoPedido(String numero_pedido);

	public Optional<PedidoModel> buscaPedidoNumeroPedido(String numeroPedido);

	public PedidoModel atualizar(PedidoModel pedido);

}
