package br.com.postechfiap.jlapp.domain.entities.webhook;

public class Webhook {

	private Long id;

	private String idNotificacao;

	private String tipoEvento;

	private String dataEvento;

	private String idWebhook;

	private Object payload;

	public Webhook() {

	}

	public Webhook(Long id, String idNotificacao, String tipoEvento, String dataEvento, String idWebhook,
			Object payload) {
		this.id = id;
		this.idNotificacao = idNotificacao;
		this.tipoEvento = tipoEvento;
		this.dataEvento = dataEvento;
		this.idWebhook = idWebhook;
		this.payload = payload;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIdNotificacao() {
		return idNotificacao;
	}

	public void setIdNotificacao(String idNotificacao) {
		this.idNotificacao = idNotificacao;
	}

	public String getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getIdWebhook() {
		return idWebhook;
	}

	public void setIdWebhook(String idWebhook) {
		this.idWebhook = idWebhook;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}

	@Override
	public String toString() {
		return "Webhook [id=" + id + ", idNotificacao=" + idNotificacao + ", tipoEvento=" + tipoEvento + ", dataEvento="
				+ dataEvento + ", idWebhook=" + idWebhook + ", payload=" + payload + "]";
	}

}
