package br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
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

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_cliente")
	private ClienteEntity clienteEntity;

	@Enumerated
	private Estado estado;

	private LocalDateTime data_pedido;

	private BigDecimal valor_pedido;

	public PedidoEntity toPedidoEntity(Pedido pedido) {
		this.id = pedido.getId();
		this.clienteEntity = new ClienteEntity().toClienteEntity(pedido.getCliente());
		this.estado = pedido.getEstado();
		this.data_pedido = pedido.getData_pedido();
		this.valor_pedido = pedido.getValor_pedido();
		return this;
	}
}
