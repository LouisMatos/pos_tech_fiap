package br.com.postechfiap.jlapp.core.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.PedidoDTO;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.StatusPedidoDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);

	public List<PedidoDTO> buscarTodos();

	public StatusPedidoDTO buscarStatusPagamentoPedido(String numero_pedido);

	public PedidoDTO buscaPedidoNumeroPedido(String numeroPedido);

	PedidoDTO atualizar(PedidoDTO pedidoDTO, String numeroPedido);

}
