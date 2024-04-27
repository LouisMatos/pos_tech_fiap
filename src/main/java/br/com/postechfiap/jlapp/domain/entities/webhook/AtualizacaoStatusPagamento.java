package br.com.postechfiap.jlapp.domain.entities.webhook;

import br.com.postechfiap.jlapp.infra.database.model.webhook.AtualizacaoStatusPagamentoEntity;

public class AtualizacaoStatusPagamento extends Evento {

	private String numeroPedido;

	private String pagamento;

	private Double valorPago;

	private String meioPagamento;

	public AtualizacaoStatusPagamento(Long id, String idNotificacao, String tipoEvento, String dataEvento,
			String idWebhook, String numeroPedido, String pagamento, Double valorPago, String meioPagamento) {
		super(id, idNotificacao, tipoEvento, dataEvento, idWebhook);
		this.numeroPedido = numeroPedido;
		this.pagamento = pagamento;
		this.valorPago = valorPago;
		this.meioPagamento = meioPagamento;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	@Override
	public String toString() {
		return "AtualizacaoStatusPagamento [numeroPedido=" + numeroPedido + ", pagamento=" + pagamento + ", valorPago="
				+ valorPago + ", meioPagamento=" + meioPagamento + "]";
	}

	public AtualizacaoStatusPagamento toAtualizacaoStatusPagamento(
			AtualizacaoStatusPagamentoEntity atualizacaoStatusPagamentoEntity) {
		this.setId(atualizacaoStatusPagamentoEntity.getId());
		this.setIdNotificacao(atualizacaoStatusPagamentoEntity.getIdNotificacao());
		this.setTipoEvento(atualizacaoStatusPagamentoEntity.getTipoEvento());
		this.setDataEvento(atualizacaoStatusPagamentoEntity.getDataEvento());
		this.setIdWebhook(atualizacaoStatusPagamentoEntity.getIdWebhook());
		this.numeroPedido = atualizacaoStatusPagamentoEntity.getNumeroPedido();
		this.pagamento = atualizacaoStatusPagamentoEntity.getPagamento();
		this.valorPago = atualizacaoStatusPagamentoEntity.getValorPago();
		this.meioPagamento = atualizacaoStatusPagamentoEntity.getMeioPagamento();
		return this;
	}

}
