package br.com.postechfiap.jlapp.adapters.in.controller.request;

import java.util.List;

import lombok.Data;

@Data
public class PedidoRequest {

	private ClienteRequest cliente;
	
	private List<ItemPedidoRequest> itens;

}
