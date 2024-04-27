package br.com.postechfiap.jlapp.domain.repositories;

import br.com.postechfiap.jlapp.domain.entities.webhook.AtualizacaoStatusPagamento;

public interface IWebhookRepository {

	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento);

}
