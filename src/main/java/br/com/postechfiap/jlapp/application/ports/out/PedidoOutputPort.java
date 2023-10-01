package br.com.postechfiap.jlapp.application.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;

public interface PedidoOutputPort {

	public Pedido inserir(Pedido pedido);

	public Optional<Pedido> buscarPedidoPorId(Long id);

}
