package br.com.postechfiap.jlapp.webhook.data.models;

import br.com.postechfiap.jlapp.webhook.domain.entities.Webhook;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebhookResponseModel {

	@JsonIgnore
	private Long id;

	@JsonProperty("id_notificacao")
	private String idNotificacao;

	@JsonProperty("tipo_evento")
	private String tipoEvento;

	@JsonProperty("data_evento")
	private String dataEvento;

	@JsonProperty("id_webhook")
	private String idWebhook;

	@JsonProperty("data")
	private Object payload;

	public WebhookResponseModel toWebhookDTO(Webhook webhook) {
		this.id = webhook.getId();
		this.idNotificacao = webhook.getIdNotificacao();
		this.tipoEvento = webhook.getTipoEvento();
		this.dataEvento = webhook.getDataEvento();
		this.idWebhook = webhook.getIdWebhook();
		this.payload = webhook.getPayload();
		return this;
	}
}
