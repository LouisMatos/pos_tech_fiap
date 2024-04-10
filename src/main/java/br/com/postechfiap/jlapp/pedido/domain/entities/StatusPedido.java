package br.com.postechfiap.jlapp.pedido.domain.entities;

import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatusPedido {

    @JsonProperty("numero_pedido")
    private String numeroPedido;

    @JsonProperty("status_pagamento")
    private StatusPagamento statusPagamento;
}
