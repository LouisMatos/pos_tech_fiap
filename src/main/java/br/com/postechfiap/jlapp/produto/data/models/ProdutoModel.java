package br.com.postechfiap.jlapp.produto.data.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity(name = "produtos")
public class ProdutoModel implements Serializable {

    private static final long serialVersionUID = -6484803166859187193L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long id;

    private String nome;

    private String descricao;

    private BigDecimal preco;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private CategoriaModel categoriaModel;

    @OneToMany(mappedBy = "produtoEntity")
    private List<ItemPedidoModel> itemPedidoModel;

    private List<String> imagens;

    public ProdutoModel toProdutoModel(Produto produto) {
        this.id = produto.getId();
        this.categoriaModel = new CategoriaModel().toCategoriaModel(produto.getCategoria());
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.imagens = produto.getImagens();
        return this;
    }

    public Produto toProduto(ProdutoModel produtoModel) {
        return new Produto(produtoModel.getId(), produtoModel.getNome(), produtoModel.getDescricao(),
                produtoModel.getPreco(), produtoModel.getCategoriaModel().toCategoria(produtoModel.getCategoriaModel()),
                produtoModel.getImagens());
    }

    public List<Produto> toListaProduto(List<ProdutoModel> produtoModels) {
        List<Produto> produtos = new ArrayList<>();
		produtoModels.forEach(produtoModel -> produtos.add(this.toProduto(produtoModel)));
		return produtos;
    }
}
