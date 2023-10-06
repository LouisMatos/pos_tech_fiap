package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.PedidoDTO;

public interface PedidoInputPort {

	public PedidoDTO inserir(PedidoDTO pedidoDTO);


}
