package br.com.postechfiap.jlapp.application.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Classe que representa um produto disponível para venda.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Categoria categoria;
    private List<String> imagens;

    /**
     * Define o nome do produto.
     *
     * @param nome O nome do produto.
     * @throws NullPointerException se o nome for nulo.
     */
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome, "O nome não pode ser nulo.");
    }

    /**
     * Define a descrição do produto.
     *
     * @param descricao A descrição do produto.
     * @throws NullPointerException se a descrição for nula.
     */
    public void setDescricao(String descricao) {
        this.descricao = Objects.requireNonNull(descricao, "A descrição não pode ser nula.");
    }

    /**
     * Define o preço do produto.
     *
     * @param preco O preço do produto.
     * @throws NullPointerException se o preço for nulo.
     */
    public void setPreco(BigDecimal preco) {
        this.preco = Objects.requireNonNull(preco, "O preço não pode ser nulo.");
    }

    /**
     * Define a categoria do produto.
     *
     * @param categoria A categoria a qual o produto pertence.
     * @throws NullPointerException se a categoria for nula.
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = Objects.requireNonNull(categoria, "A categoria não pode ser nula.");
    }

    /**
     * Define a lista de imagens do produto.
     *
     * @param imagens A lista de URLs das imagens do produto.
     * @throws NullPointerException se a lista de imagens for nula.
     */
    public void setImagens(List<String> imagens) {
        this.imagens = Objects.requireNonNull(imagens, "A lista de imagens não pode ser nula.");
    }

    // O Lombok gera os demais métodos como equals, hashCode e toString.
    // Métodos toProduto foram removidos, a lógica de conversão deve estar em uma classe de mapeamento dedicada.
}
