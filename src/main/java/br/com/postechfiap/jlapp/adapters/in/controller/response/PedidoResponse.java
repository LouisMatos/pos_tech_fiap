package br.com.postechfiap.jlapp.adapters.in.controller.response;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import lombok.Data;

@Data
public class PedidoResponse {
	
	private Cliente cliente;

	private List<ItemPedido> itens;

	private Estado estado;

}
