package br.com.postechfiap.jlapp.produto.data.models;

import br.com.postechfiap.jlapp.produto.domain.entities.Produto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProdutoResponseModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("preco")
    private BigDecimal preco;

    @JsonProperty("categoria")
    @JsonInclude(Include.NON_NULL)
    private Long categoriaId;

    @JsonProperty("categoria_nome")
    private String categoriaNome;

    @JsonProperty("imagens")
    private List<String> imagens;

    public static ProdutoResponseModel toProdutoResponseModel(Produto produto) {
        ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel();
        produtoResponseModel.setId(produto.getId());
        produtoResponseModel.setNome(produto.getNome());
        produtoResponseModel.setDescricao(produto.getDescricao());
        produtoResponseModel.setPreco(produto.getPreco());
        produtoResponseModel.setCategoriaId(produto.getCategoria().getId());
        produtoResponseModel.setCategoriaNome(produto.getCategoria().getNome());
        produtoResponseModel.setImagens(produto.getImagens());
        return produtoResponseModel;
    }

    public static Produto toProduto(ProdutoRequestModel produtoRequestModel) {
        Produto produto = new Produto();
        produto.setId(produtoRequestModel.getId());
        produto.setNome(produtoRequestModel.getNome());
        produto.setDescricao(produtoRequestModel.getDescricao());
        produto.setPreco(produtoRequestModel.getPreco());
        return produto;
    }

    public static List<ProdutoResponseModel> toListaProdutoResponseModel(List<ProdutoRequestModel> produtoRequestModels) {
        return produtoRequestModels.stream()
                .map(ProdutoResponseModel::toProduto)
                .map(ProdutoResponseModel::toProdutoResponseModel)
                .toList();
    }

    public ProdutoResponseModel toProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.categoriaId = produto.getCategoria().getId();
        this.categoriaNome = produto.getCategoria().getNome();
        this.imagens = produto.getImagens();
        return this;
    }

}
