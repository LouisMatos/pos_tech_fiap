package br.com.postechfiap.jlapp.webhook.data.models;

import br.com.postechfiap.jlapp.webhook.domain.entities.AtualizacaoStatusPagamento;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "atualizacao_status_pagamento")
public class AtualizacaoStatusPagamentoModel extends EventoModel {

	private static final long serialVersionUID = -4449804229929062359L;

	private String numeroPedido;

	private String pagamento;

	private Double valorPago;

	private String meioPagamento;

	public AtualizacaoStatusPagamentoModel toAtualizacaoStatusPagamentoEntity(
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