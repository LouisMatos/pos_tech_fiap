package br.com.postechfiap.jlapp.core.ports.out;

import br.com.postechfiap.jlapp.webhook.domain.entities.AtualizacaoStatusPagamento;

public interface WebhookOutputPort {

	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento);

}
