package br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity;

import java.io.Serializable;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
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
	@Column(name = "id_item_pedido")
	private Long id;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
	private PedidoEntity pedidoEntity;

	@Column(name = "pedidoid")
	private Long pedidoid;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
	private ProdutoEntity produtoEntity;

	private int quantidade;

	private String observacao;

	public ItemPedidoEntity toItemPedidoEntity(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
		this.pedidoid = itemPedido.getPedidoid();
		this.produtoEntity = new ProdutoEntity().toProdutoEntity(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
		return this;
	}

}
