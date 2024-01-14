package br.com.postechfiap.jlapp.core.usecase;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import br.com.postechfiap.jlapp.core.entities.webhook.AtualizacaoStatusPagamento;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.core.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.core.ports.in.WebhookInputPort;
import br.com.postechfiap.jlapp.core.ports.out.WebhookOutputPort;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.PedidoDTO;
import br.com.postechfiap.jlapp.infrastructure.controllers.dto.WebhookDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

public class WebhookUseCase implements WebhookInputPort {

	private final Logger log;
	private final WebhookOutputPort webhookOutputPort;
	private final PedidoInputPort pedidoInputPort;
	private static final String EVENTO_NOTIFICACAO_ATUALIZACAO_PAGAMENTO = "notificacao_atualizacao_status_pagamento";

	public WebhookUseCase(WebhookOutputPort webhookOutputPort, PedidoInputPort pedidoInputPort, Logger log) {
		this.webhookOutputPort = webhookOutputPort;
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
			AtualizacaoStatusPagamento statusPagamento = webhookOutputPort.inserir(atualizacaoStatusPagamento);
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
