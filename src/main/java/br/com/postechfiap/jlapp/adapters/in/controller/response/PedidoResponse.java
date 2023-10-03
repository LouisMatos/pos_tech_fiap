package br.com.postechfiap.jlapp.adapters.in.controller.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import lombok.Data;

@Data
public class PedidoResponse {
	
	private Long id;
	
	private Cliente cliente;

	private List<ItemPedido> itens;

	private Estado estado;
	
	private LocalDateTime data_pedido;

	private BigDecimal valor_pedido;

}
