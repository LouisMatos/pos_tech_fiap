package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Entity(name = "itens_pedido")
public class ItemPedidoEntity implements Serializable {

	private static final long serialVersionUID = 5574805510444162776L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

//	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, targetEntity = PedidoEntity.class)
//	@MapsId("id")
//	@JoinColumn(name = "pedido_id")
	@JoinColumn(name = "pedido_id")
	private PedidoEntity pedidoEntity;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id")
	private ProdutoEntity produtoEntity;

	private int quantidade;

	private String observacao;

}
