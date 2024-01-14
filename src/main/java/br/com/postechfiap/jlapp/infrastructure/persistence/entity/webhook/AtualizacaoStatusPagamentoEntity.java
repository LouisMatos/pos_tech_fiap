package br.com.postechfiap.jlapp.infrastructure.persistence.entity.webhook;

import br.com.postechfiap.jlapp.core.entities.webhook.AtualizacaoStatusPagamento;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "atualizacao_status_pagamento")
public class AtualizacaoStatusPagamentoEntity extends EventoEntity {

	private static final long serialVersionUID = -4449804229929062359L;

	private String numeroPedido;

	private String pagamento;

	private Double valorPago;

	private String meioPagamento;

	public AtualizacaoStatusPagamentoEntity toAtualizacaoStatusPagamentoEntity(
			AtualizacaoStatusPagamento atualizacaoStatusPagamento) {
		this.setId(atualizacaoStatusPagamento.getId());
		this.setIdNotificacao(atualizacaoStatusPagamento.getIdNotificacao());
		this.setTipoEvento(atualizacaoStatusPagamento.getTipoEvento());
		this.setDataEvento(atualizacaoStatusPagamento.getDataEvento());
		this.setIdWebhook(atualizacaoStatusPagamento.getIdWebhook());
		this.numeroPedido = atualizacaoStatusPagamento.getNumeroPedido();
		this.pagamento = atualizacaoStatusPagamento.getPagamento();
		this.valorPago = atualizacaoStatusPagamento.getValorPago();
		this.meioPagamento = atualizacaoStatusPagamento.getMeioPagamento();
		return this;
	}

}