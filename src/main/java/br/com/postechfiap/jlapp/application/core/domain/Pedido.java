package br.com.postechfiap.jlapp.application.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import br.com.postechfiap.jlapp.application.enums.Estado;

/**
 * Classe que representa um pedido dentro do sistema.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    private Long id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private Estado estado;
    private LocalDateTime dataPedido;
    private BigDecimal valorPedido;

    /**
     * Define o cliente associado ao pedido.
     *
     * @param cliente O cliente que realizou o pedido.
     * @throws NullPointerException se o cliente for nulo.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = Objects.requireNonNull(cliente, "O cliente não pode ser nulo.");
    }

    /**
     * Define os itens do pedido.
     *
     * @param itens A lista de itens que compõem o pedido.
     * @throws NullPointerException se a lista de itens for nula.
     */
    public void setItens(List<ItemPedido> itens) {
        this.itens = Objects.requireNonNull(itens, "A lista de itens não pode ser nula.");
    }

    // Métodos getEstado, setId, setDataPedido e setValorPedido não precisam de validações adicionais e são gerados pelo Lombok.

    // O Lombok gera os métodos equals, hashCode e toString.
    // Métodos toPedido foram removidos, a lógica de conversão deve estar em uma classe de mapeamento dedicada.
}
