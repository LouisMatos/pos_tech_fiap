package br.com.postechfiap.jlapp.infrastructure.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.core.enums.Estado;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusPedidoTesteDTO {

	@JsonProperty("numero_pedido")
	private String numeroPedido;

	@JsonProperty("estado")
	private Estado estado;

}
