package br.com.postechfiap.jlapp.core.ports.out;

import br.com.postechfiap.jlapp.core.entities.webhook.AtualizacaoStatusPagamento;

public interface WebhookOutputPort {

	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento);

}
