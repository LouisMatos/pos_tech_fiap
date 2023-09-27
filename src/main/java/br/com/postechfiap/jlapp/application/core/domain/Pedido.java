package br.com.postechfiap.jlapp.application.core.domain;

import java.util.List;

import br.com.postechfiap.jlapp.application.enums.Estado;

public class Pedido {

	private Cliente cliente;

	private List<ItemPedido> itens;

	private Estado estado;

	public Pedido() {

	}

	public Pedido(Cliente cliente, List<ItemPedido> itens, Estado estado) {
		this.cliente = cliente;
		this.itens = itens;
		this.estado = estado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pedido [cliente=" + cliente + ", itens=" + itens + ", estado=" + estado + "]";
	}
	
	

}
