package br.com.postechfiap.jlapp.application.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Objects;

/**
 * Representa uma categoria de produtos no domínio da aplicação.
 * <p>
 * Esta classe é uma parte central do modelo de domínio e é usada para agrupar produtos similares.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Categoria {

    private Long id;
    private String nomeCategoria;
    private String descricao;
    private List<Produto> produtos;

    /**
     * Define o nome da categoria.
     *
     * @param nomeCategoria O nome representativo da categoria.
     * @throws IllegalArgumentException se o nome da categoria for nulo ou vazio.
     */
    public void setNomeCategoria(String nomeCategoria) {
        if (Objects.requireNonNull(nomeCategoria).isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio.");
        }
        this.nomeCategoria = nomeCategoria;
    }

    /**
     * Define a descrição da categoria.
     *
     * @param descricao A descrição detalhada da categoria.
     * @throws IllegalArgumentException se a descrição for nula ou vazia.
     */
    public void setDescricao(String descricao) {
        if (Objects.requireNonNull(descricao).isEmpty()) {
            throw new IllegalArgumentException("A descrição não pode ser vazia.");
        }
        this.descricao = descricao;
    }

    /**
     * Define a lista de produtos da categoria.
     *
     * @param produtos A lista de produtos pertencentes a esta categoria.
     * @throws IllegalArgumentException se a lista de produtos for nula.
     */
    public void setProdutos(List<Produto> produtos) {
        this.produtos = Objects.requireNonNull(produtos, "A lista de produtos não pode ser nula.");
    }

    // Note que os métodos 'equals', 'hashCode', e 'toString' são gerados pelo Lombok (@Data).
}
