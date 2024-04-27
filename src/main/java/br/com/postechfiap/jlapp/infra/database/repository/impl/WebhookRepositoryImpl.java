package br.com.postechfiap.jlapp.infra.database.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.webhook.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.infra.database.repository.IWebhookRepository;
import br.com.postechfiap.jlapp.infra.database.model.webhook.AtualizacaoStatusPagamentoEntity;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class WebhookRepositoryImpl implements br.com.postechfiap.jlapp.domain.repositories.IWebhookRepository {

	@Autowired
	private IWebhookRepository IWebhookRepository;

	@Autowired
	private Logger log;

	@Override
	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento) {
		AtualizacaoStatusPagamentoEntity atualizacaoStatusPagamentoEntity = new AtualizacaoStatusPagamentoEntity()
				.toAtualizacaoStatusPagamentoEntity(atualizacaoStatusPagamento);
		log.info("Salvando novo evento atualizacao Status Pagamento no banco de dados!");
		return atualizacaoStatusPagamento.toAtualizacaoStatusPagamento(IWebhookRepository.save(atualizacaoStatusPagamentoEntity));
	}

}
