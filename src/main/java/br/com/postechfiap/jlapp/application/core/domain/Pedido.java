package br.com.postechfiap.jlapp.application.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.PedidoDTO;

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

	public Pedido toPedido(PedidoDTO pedidoDTO) {
		this.id = pedidoDTO.getId();
		if(pedidoDTO.getClienteDTO()!= null) {
			this.cliente = new Cliente().toCliente(pedidoDTO.getClienteDTO());
		}
		this.itens = pedidoDTO.getItemPedidoDTOs().stream().map(dto -> new ItemPedido().toItemPedido(dto))
				.collect((Collectors.toList()));
		this.estado = pedidoDTO.getEstado();
		this.data_pedido = pedidoDTO.getData_pedido();
		this.valor_pedido = pedidoDTO.getValor_pedido();
		return this;

	}

	public Pedido toPedido(PedidoEntity pedidoEntity) {
		this.id = pedidoEntity.getId();
		if(pedidoEntity.getClienteEntity() != null) {
			this.cliente = new Cliente().toCliente(pedidoEntity.getClienteEntity());
		}
//		this.itens = pedidoEntity.getItensPedidoEntities().stream().map(dto -> new ItemPedido().toItemPedido(dto))
//				.collect((Collectors.toList()));
		this.estado = pedidoEntity.getEstado();
		this.data_pedido = pedidoEntity.getData_pedido();
		this.valor_pedido = pedidoEntity.getValor_pedido();
		return this;
	}

}
