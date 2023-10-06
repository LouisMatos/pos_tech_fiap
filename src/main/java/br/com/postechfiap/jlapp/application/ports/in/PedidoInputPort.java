package br.com.postechfiap.jlapp.application.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.PedidoDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);

	public List<PedidoDTO> buscarTodos();


}
