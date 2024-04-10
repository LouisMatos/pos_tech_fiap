package br.com.postechfiap.jlapp.pedido.data.models;

import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "itens_pedido")
public class ItemPedidoModel implements Serializable {

    private static final long serialVersionUID = 5574805510444162776L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pedido")
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private PedidoModel pedidoModel;

    @Column(name = "pedidoid")
    private Long pedidoid;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    private ProdutoModel produtoModel;

    private int quantidade;

    private String observacao;


    public ItemPedidoModel toItemPedidoModel(ItemPedido itemPedido) {
        this.id = itemPedido.getId();
        this.pedidoid = itemPedido.getPedidoid();
        this.produtoModel = new ProdutoModel().toProdutoModel(itemPedido.getProduto());
        this.quantidade = itemPedido.getQuantidade();
        this.observacao = itemPedido.getObservacao();
        return this;
    }

    public ItemPedido toItemPedido(ItemPedidoModel itemPedidoModel) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(itemPedidoModel.getId());
        itemPedido.setPedidoid(itemPedidoModel.getPedidoid());
        itemPedido.setProduto(itemPedidoModel.getProdutoModel().toProduto(itemPedidoModel.getProdutoModel()));
        itemPedido.setQuantidade(itemPedidoModel.getQuantidade());
        itemPedido.setObservacao(itemPedidoModel.getObservacao());
        return itemPedido;
    }

    public List<ItemPedido> toListaItemPedidoModel(List<ItemPedidoModel> itemPedidoModels) {
        return itemPedidoModels.stream()
                .map(this::toItemPedido)
                .collect(Collectors.toList());
    }

	public List<ItemPedido> toListaItemPedido(List<ItemPedidoModel> itemPedidoModels) {
		return itemPedidoModels.stream()
				.map(this::toItemPedido)
				.collect(Collectors.toList());
	}
}
