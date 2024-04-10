package br.com.postechfiap.jlapp.webhook.domain.usecases;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.postechfiap.jlapp.webhook.domain.entities.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.pedido.domain.repositories.PedidoRepository;
import br.com.postechfiap.jlapp.core.ports.in.WebhookInputPort;
import br.com.postechfiap.jlapp.core.ports.out.WebhookOutputPort;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoRequestModel;
import br.com.postechfiap.jlapp.webhook.data.models.WebhookRequestModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

public class WebhookUseCase implements WebhookInputPort {

	private final Logger log;
	private final WebhookOutputPort webhookOutputPort;
	private final PedidoRepository pedidoRepository;
	private static final String EVENTO_NOTIFICACAO_ATUALIZACAO_PAGAMENTO = "notificacao_atualizacao_status_pagamento";

	public WebhookUseCase(WebhookOutputPort webhookOutputPort, PedidoRepository pedidoRepository, Logger log) {
		this.webhookOutputPort = webhookOutputPort;
		this.pedidoRepository = pedidoRepository;
		this.log = log;
	}

	@Override
	public void recuperandoEventoWebhook(WebhookRequestModel webhookRequestModel) {

		log.info("Evento webhook recebido! Evento: {}", webhookRequestModel.toString());

		String tipoEvento = webhookRequestModel.getTipoEvento();

		log.info("Tipo de evento recebido: {}", tipoEvento);

		if (tipoEvento.equals(EVENTO_NOTIFICACAO_ATUALIZACAO_PAGAMENTO)) {
			AtualizacaoStatusPagamento atualizacaoStatusPagamento = recuperaAtualizacaoStatusPagamento(webhookRequestModel);
			AtualizacaoStatusPagamento statusPagamento = webhookOutputPort.inserir(atualizacaoStatusPagamento);
			log.info("Evento: {} salvo com sucesso!", statusPagamento.toString());

			log.info("Iniciando atualização de status de pagamento do pedido!");

			PedidoRequestModel pedidoRequestModel = pedidoRepository.buscaPedidoNumeroPedido(statusPagamento.getNumeroPedido());

			log.info("Atualizando status de pagamento do pedido {} de {} > para {}", statusPagamento.getNumeroPedido(),
					pedidoRequestModel.getStatusPagamento(), statusPagamento.getPagamento());
			pedidoRequestModel.setStatusPagamento(StatusPagamento.valueOf(statusPagamento.getPagamento()));

			pedidoRepository.atualizar(pedidoRequestModel, statusPagamento.getNumeroPedido());

		}

	}

	private AtualizacaoStatusPagamento recuperaAtualizacaoStatusPagamento(WebhookRequestModel webhookRequestModel) {

		if (webhookRequestModel.getPayload() != null) {
			Gson gson = new Gson();

			JsonElement jsonElement = gson.toJsonTree(webhookRequestModel.getPayload());
			JsonObject payload = (JsonObject) jsonElement;

			AtualizacaoStatusPagamento atualizacaoStatusPagamento = new AtualizacaoStatusPagamento(webhookRequestModel.getId(),
					webhookRequestModel.getIdNotificacao(), webhookRequestModel.getTipoEvento(), webhookRequestModel.getDataEvento(),
					webhookRequestModel.getIdWebhook(), payload.get("numero_pedido").getAsString(),
					payload.get("pagamento").getAsString(), payload.get("valor_pago").getAsDouble(),
					payload.get("meio_pagamento").getAsString());

			log.info("Evento Atualização de pagamento: {}", atualizacaoStatusPagamento.toString());

			return atualizacaoStatusPagamento;
		}

		return null;
	}

}
