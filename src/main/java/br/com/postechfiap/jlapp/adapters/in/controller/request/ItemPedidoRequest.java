package br.com.postechfiap.jlapp.adapters.in.controller.request;

import lombok.Data;

@Data
public class ItemPedidoRequest {

	private Long produto;

	private int quantidade;

	private String observacao;

}
