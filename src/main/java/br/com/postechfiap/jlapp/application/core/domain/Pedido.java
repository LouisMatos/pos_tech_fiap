package br.com.postechfiap.jlapp.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.application.enums.Estado;

public class Pedido {

	private Long id;

	private Cliente cliente;

	private List<ItemPedido> itens = new ArrayList<ItemPedido>();

	private Estado estado;

	private LocalDateTime data_pedido;

	private BigDecimal valor_pedido;

	public Pedido() {

	}

	public Pedido(Long id, Cliente cliente, List<ItemPedido> itens, Estado estado, LocalDateTime data_pedido,
			BigDecimal valor_pedido) {
		this.id = id;
		this.cliente = cliente;
		this.itens = itens;
		this.estado = estado;
		this.data_pedido = data_pedido;
		this.valor_pedido = valor_pedido;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getData_pedido() {
		return data_pedido;
	}

	public void setData_pedido(LocalDateTime data_pedido) {
		this.data_pedido = data_pedido;
	}

	public BigDecimal getValor_pedido() {
		return valor_pedido;
	}

	public void setValor_pedido(BigDecimal valor_pedido) {
		this.valor_pedido = valor_pedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", itens=" + itens + ", estado=" + estado
				+ ", data_pedido=" + data_pedido + ", valor_pedido=" + valor_pedido + "]";
	}

}
