package br.com.postechfiap.jlapp.infrastructure.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.webhook.domain.entities.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.core.ports.out.WebhookOutputPort;
import br.com.postechfiap.jlapp.infrastructure.persistence.WebhookRepository;
import br.com.postechfiap.jlapp.webhook.data.models.AtualizacaoStatusPagamentoModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

@Component
public class WebhookAdapter implements WebhookOutputPort {

	@Autowired
	private WebhookRepository webhookRepository;

	@Autowired
	private Logger log;

	@Override
	public AtualizacaoStatusPagamento inserir(AtualizacaoStatusPagamento atualizacaoStatusPagamento) {
		AtualizacaoStatusPagamentoModel atualizacaoStatusPagamentoEntity = new AtualizacaoStatusPagamentoModel()
				.toAtualizacaoStatusPagamentoEntity(atualizacaoStatusPagamento);
		log.info("Salvando novo evento atualizacao Status Pagamento no banco de dados!");
		return atualizacaoStatusPagamento.toAtualizacaoStatusPagamento(webhookRepository.save(atualizacaoStatusPagamentoEntity));
	}

}
