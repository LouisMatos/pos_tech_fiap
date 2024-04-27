package br.com.postechfiap.jlapp.domain.enums;

public enum StatusPagamento {

	AGUARDANDO(1), //
	APROVADO(2), //
	NEGADO(3); //

	private int statusPagamento;

	StatusPagamento(int statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public boolean estaAguardando() {
		return AGUARDANDO.getValorEstado() == this.statusPagamento;
	}

	public boolean estaAprovado() {
		return APROVADO.getValorEstado() == this.statusPagamento;
	}

	public boolean estaNegado() {
		return NEGADO.getValorEstado() == this.statusPagamento;
	}

	public int getValorEstado() {
		return this.statusPagamento;
	}

}
