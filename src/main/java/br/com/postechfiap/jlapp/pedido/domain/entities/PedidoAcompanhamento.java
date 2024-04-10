package br.com.postechfiap.jlapp.pedido.domain.entities;

import br.com.postechfiap.jlapp.core.enums.Estado;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PedidoAcompanhamento {

    @JsonProperty("numero_pedido")
    private String numeroPedido;

    @JsonProperty("estado")
    private Estado estado;

    @JsonProperty("nome_cliente")
    private String nomeCliente;

    @JsonProperty("data_pedido")
    private LocalDateTime dataPedido;

    public PedidoAcompanhamento toPedidoAcompanhamento(Pedido pedido) {
        PedidoAcompanhamento pedidoAcompanhamento = new PedidoAcompanhamento();
        pedidoAcompanhamento.setNumeroPedido(pedido.getNumeroPedido());
        pedidoAcompanhamento.setEstado(pedido.getEstado());
        pedidoAcompanhamento.setNomeCliente(pedido.getCliente().getNome());
        pedidoAcompanhamento.setDataPedido(pedido.getDataPedido());
        return pedidoAcompanhamento;
    }
}
