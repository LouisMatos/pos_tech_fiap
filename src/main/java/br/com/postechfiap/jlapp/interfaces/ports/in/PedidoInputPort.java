package br.com.postechfiap.jlapp.interfaces.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.interfaces.dto.PedidoDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);

	public List<PedidoDTO> buscarTodos();


}
