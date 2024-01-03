package br.com.postechfiap.jlapp.application.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.PedidoEntity;
import br.com.postechfiap.jlapp.interfaces.adapters.dto.PedidoDTO;

public class Pedido {

	private Long id;

	private Cliente cliente;

	private List<ItemPedido> itens = new ArrayList<>();

	private Estado estado;

	private LocalDateTime dataPedido;

	private BigDecimal valorPedido;

	public Pedido() {

	}

	public Pedido(Long id, Cliente cliente, List<ItemPedido> itens, Estado estado, LocalDateTime dataPedido,
			BigDecimal valorPedido) {
		this.id = id;
		this.cliente = cliente;
		this.itens = itens;
		this.estado = estado;
		this.dataPedido = dataPedido;
		this.valorPedido = valorPedido;
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

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public BigDecimal getValorPedido() {
		return valorPedido;
	}

	public void setValorPedido(BigDecimal valorPedido) {
		this.valorPedido = valorPedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", itens=" + itens + ", estado=" + estado + ", dataPedido="
				+ dataPedido + ", valorPedido=" + valorPedido + "]";
	}

	public Pedido toPedido(PedidoDTO pedidoDTO) {
		this.id = pedidoDTO.getId();
		if (pedidoDTO.getClienteDTO() != null) {
			this.cliente = new Cliente().toCliente(pedidoDTO.getClienteDTO());
		}
		this.itens = pedidoDTO.getItemPedidoDTOs().stream().map(dto -> new ItemPedido().toItemPedido(dto))
				.collect((Collectors.toList()));
		this.estado = pedidoDTO.getEstado();
		this.dataPedido = pedidoDTO.getDataPedido();
		this.valorPedido = pedidoDTO.getValorPedido();
		return this;

	}

	public Pedido toPedido(PedidoEntity pedidoEntity) {
		this.id = pedidoEntity.getId();
		if (pedidoEntity.getClienteEntity() != null) {
			this.cliente = new Cliente().toCliente(pedidoEntity.getClienteEntity());
		}
		this.estado = pedidoEntity.getEstado();
		this.dataPedido = pedidoEntity.getDataPedido();
		this.valorPedido = pedidoEntity.getValorPedido();
		return this;
	}

}