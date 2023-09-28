package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.application.enums.Estado;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "pedidos")
public class PedidoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private ClienteEntity clienteEntity;

	@OneToMany(mappedBy = "pedidoEntity", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<ItemPedidoEntity> itensPedidoEntities = new ArrayList<>();;

	@Enumerated
	private Estado estado;
}
