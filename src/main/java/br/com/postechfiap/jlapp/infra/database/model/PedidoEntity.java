package br.com.postechfiap.jlapp.infra.database.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import br.com.postechfiap.jlapp.domain.entities.Pedido;
import br.com.postechfiap.jlapp.domain.enums.Estado;
import br.com.postechfiap.jlapp.domain.enums.StatusPagamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedidos")
public class PedidoEntity implements Serializable {

	private static final long serialVersionUID = 106181416585362479L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;

	private String numeroPedido;

	@Enumerated
	private StatusPagamento statusPagamento;

	@ManyToOne(optional = true, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(nullable = true, name = "id_cliente")
	private ClienteEntity clienteEntity;

	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, mappedBy = "pedidoEntity")
	private List<ItemPedidoEntity> itemPedidoEntities;

	@Enumerated
	private Estado estado;

	private LocalDateTime dataPedido;

	private BigDecimal valorPedido;

	public PedidoEntity toPedidoEntity(Pedido pedido) {
		this.id = pedido.getId();
		this.numeroPedido = pedido.getNumeroPedido();
		this.statusPagamento = pedido.getStatusPagamento();
		if (pedido.getCliente() != null) {
			this.clienteEntity = new ClienteEntity().toClienteEntity(pedido.getCliente());
		}
		this.estado = pedido.getEstado();
		this.dataPedido = pedido.getDataPedido();
		this.valorPedido = pedido.getValorPedido();
		return this;
	}
}
