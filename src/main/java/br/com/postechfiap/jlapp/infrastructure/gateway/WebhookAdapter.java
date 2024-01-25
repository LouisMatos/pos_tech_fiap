package br.com.postechfiap.jlapp.infrastructure.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.core.entities.webhook.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.core.ports.out.WebhookOutputPort;
import br.com.postechfiap.jlapp.infrastructure.persistence.WebhookRepository;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.webhook.AtualizacaoStatusPagamentoEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class WebhookAdapter implements WebhookOutputPort {

	@Autowired
	private WebhookRepository webhookRepository;

	@Autowired
	private Logger log;

	@Override
	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento) {
		AtualizacaoStatusPagamentoEntity atualizacaoStatusPagamentoEntity = new AtualizacaoStatusPagamentoEntity()
				.toAtualizacaoStatusPagamentoEntity(atualizacaoStatusPagamento);
		log.info("Salvando novo evento atualizacao Status Pagamento no banco de dados!");
		return atualizacaoStatusPagamento.toAtualizacaoStatusPagamento(webhookRepository.save(atualizacaoStatusPagamentoEntity));
	}

}
