package br.com.postechfiap.jlapp.core.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.PedidoDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);

	public List<PedidoDTO> buscarTodos();


}
