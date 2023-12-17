package br.com.postechfiap.jlapp.application.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

    private Long id;
    private Long pedidoId; // Nome da variável alterado para camelCase
    private Produto produto;
    private int quantidade;
    private String observacao;

    /**
     * Define a quantidade do item pedido.
     *
     * @param quantidade A quantidade do produto no pedido.
     * @throws IllegalArgumentException se a quantidade for menor ou igual a zero.
     */
    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }

    /**
     * Define a observação para o item do pedido.
     *
     * @param observacao A observação associada ao item do pedido.
     * @throws NullPointerException se a observação for nula.
     */
    public void setObservacao(String observacao) {
        this.observacao = Objects.requireNonNull(observacao, "A observação não pode ser nula.");
    }

}
