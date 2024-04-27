package br.com.postechfiap.jlapp.domain.usecase;

import br.com.postechfiap.jlapp.domain.dtos.PedidoDTO;
import br.com.postechfiap.jlapp.domain.dtos.WebhookDTO;
import br.com.postechfiap.jlapp.domain.entities.webhook.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.domain.enums.StatusPagamento;
import br.com.postechfiap.jlapp.domain.interfaces.PedidoInputPort;
import br.com.postechfiap.jlapp.domain.interfaces.WebhookInputPort;
import br.com.postechfiap.jlapp.domain.repositories.IWebhookRepository;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class WebhookUseCase implements WebhookInputPort {

	private final Logger log;
	private final IWebhookRepository IWebhookRepository;
	private final PedidoInputPort pedidoInputPort;
	private static final String EVENTO_NOTIFICACAO_ATUALIZACAO_PAGAMENTO = "notificacao_atualizacao_status_pagamento";

	public WebhookUseCase(IWebhookRepository IWebhookRepository, PedidoInputPort pedidoInputPort, Logger log) {
		this.IWebhookRepository = IWebhookRepository;
		this.pedidoInputPort = pedidoInputPort;
		this.log = log;
	}

	@Override
	public void recuperandoEventoWebhook(WebhookDTO webhookDTO) {

		log.info("Evento webhook recebido! Evento: {}", webhookDTO.toString());

		String tipoEvento = webhookDTO.getTipoEvento();

		log.info("Tipo de evento recebido: {}", tipoEvento);

		if (tipoEvento.equals(EVENTO_NOTIFICACAO_ATUALIZACAO_PAGAMENTO)) {
			AtualizacaoStatusPagamento atualizacaoStatusPagamento = recuperaAtualizacaoStatusPagamento(webhookDTO);
			AtualizacaoStatusPagamento statusPagamento = IWebhookRepository.inserir(atualizacaoStatusPagamento);
			log.info("Evento: {} salvo com sucesso!", statusPagamento.toString());

			log.info("Iniciando atualização de status de pagamento do pedido!");

			PedidoDTO pedidoDTO = pedidoInputPort.buscaPedidoNumeroPedido(statusPagamento.getNumeroPedido());

			log.info("Atualizando status de pagamento do pedido {} de {} > para {}", statusPagamento.getNumeroPedido(),
					pedidoDTO.getStatusPagamento(), statusPagamento.getPagamento());
			pedidoDTO.setStatusPagamento(StatusPagamento.valueOf(statusPagamento.getPagamento()));

			pedidoInputPort.atualizar(pedidoDTO, statusPagamento.getNumeroPedido());

		}

	}

	private AtualizacaoStatusPagamento recuperaAtualizacaoStatusPagamento(WebhookDTO webhookDTO) {

		if (webhookDTO.getPayload() != null) {
			Gson gson = new Gson();

			JsonElement jsonElement = gson.toJsonTree(webhookDTO.getPayload());
			JsonObject payload = (JsonObject) jsonElement;

			AtualizacaoStatusPagamento atualizacaoStatusPagamento = new AtualizacaoStatusPagamento(webhookDTO.getId(),
					webhookDTO.getIdNotificacao(), webhookDTO.getTipoEvento(), webhookDTO.getDataEvento(),
					webhookDTO.getIdWebhook(), payload.get("numero_pedido").getAsString(),
					payload.get("pagamento").getAsString(), payload.get("valor_pago").getAsDouble(),
					payload.get("meio_pagamento").getAsString());

			log.info("Evento Atualização de pagamento: {}", atualizacaoStatusPagamento.toString());

			return atualizacaoStatusPagamento;
		}

		return null;
	}

}
