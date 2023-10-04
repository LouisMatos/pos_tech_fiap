package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.io.Serializable;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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

//	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_pedido_fk", referencedColumnName = "id_pedido", foreignKey = @ForeignKey(name = "id_pedido_fk_esta_para_id_pedido"))
	private PedidoEntity pedidoEntity;

//	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
//	@JoinColumn(name = "id_produto_fk", referencedColumnName = "id_produto", foreignKey = @ForeignKey(name = "id_produto_fk_esta_para_id_produto"))
	private ProdutoEntity produtoEntity;

	private int quantidade;

	private String observacao;

	public ItemPedidoEntity toItensPedidosEntities(ItemPedido itemPedido) {
		this.id = itemPedido.getId();
//		this.pedidoEntity = new PedidoEntity().toPedidoEntity(itemPedido.getPedido());
		this.produtoEntity = new ProdutoEntity().toProdutoEntity(itemPedido.getProduto());
		this.quantidade = itemPedido.getQuantidade();
		this.observacao = itemPedido.getObservacao();
		return this;
	}

}
