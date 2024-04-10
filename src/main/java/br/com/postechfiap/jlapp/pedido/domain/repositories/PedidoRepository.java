package br.com.postechfiap.jlapp.pedido.domain.repositories;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoAcompanhamentoRequestModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.StatusPedido;
import br.com.postechfiap.jlapp.webhook.data.models.StatusPedidoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;

public interface PedidoRepository {

	public Pedido inserir(Pedido pedido);

	public List<Pedido> buscarTodos();

	public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido);

	public Optional<Pedido> buscaPedidoNumeroPedido(String numeroPedido);


	Pedido atualizar(Pedido pedido, String numeroPedido);

	Pedido atualizar(Pedido pedido);

	public List<PedidoAcompanhamentoRequestModel> buscarPedidosAcompanhamento();

	public StatusPedidoTesteDTO atualizaStatusPedidoTeste(StatusPedidoTesteDTO statusPedidoTesteDTO);

}
