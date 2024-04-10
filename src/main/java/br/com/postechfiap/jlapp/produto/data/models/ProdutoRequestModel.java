package br.com.postechfiap.jlapp.produto.data.models;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import br.com.postechfiap.jlapp.produto.domain.entities.Produto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ProdutoRequestModel {

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

    public static Produto toProduto(ProdutoRequestModel produtoRequestModel) {
        Produto produto = new Produto();
        produto.setId(produtoRequestModel.getId());
        produto.setNome(produtoRequestModel.getNome());
        produto.setDescricao(produtoRequestModel.getDescricao());
        produto.setPreco(produtoRequestModel.getPreco());
        return produto;
    }

    public ProdutoRequestModel toProdutoDTO(Produto produto) {
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
