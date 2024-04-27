package br.com.postechfiap.jlapp.domain.interfaces;

import java.util.List;

import br.com.postechfiap.jlapp.domain.dtos.PedidoAcompanhamentoDTO;
import br.com.postechfiap.jlapp.domain.dtos.PedidoDTO;
import br.com.postechfiap.jlapp.domain.dtos.StatusPedidoDTO;
import br.com.postechfiap.jlapp.domain.dtos.StatusPedidoTesteDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);

	public List<PedidoDTO> buscarTodos();

	public StatusPedidoDTO buscarStatusPagamentoPedido(String numero_pedido);

	public PedidoDTO buscaPedidoNumeroPedido(String numeroPedido);

	PedidoDTO atualizar(PedidoDTO pedidoDTO, String numeroPedido);

	public List<PedidoAcompanhamentoDTO> buscarPedidosAcompanhamento();

	public StatusPedidoTesteDTO atualizaStatusPedidoTeste(StatusPedidoTesteDTO statusPedidoTesteDTO);

}
