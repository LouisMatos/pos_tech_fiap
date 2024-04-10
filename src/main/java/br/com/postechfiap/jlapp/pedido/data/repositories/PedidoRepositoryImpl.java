package br.com.postechfiap.jlapp.pedido.data.repositories;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoAcompanhamentoRequestModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.StatusPedido;
import br.com.postechfiap.jlapp.webhook.data.models.StatusPedidoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.pedido.data.datasources.PedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import br.com.postechfiap.jlapp.pedido.domain.repositories.PedidoRepository;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

import java.util.List;
import java.util.Optional;

public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoDatasources pedidoDatasources;

    private final Logger log;

    private final PedidoModel pedidoModel;

    public PedidoRepositoryImpl(PedidoDatasources pedidoDatasources, Logger log, PedidoModel pedidoModel) {
        this.pedidoDatasources = pedidoDatasources;
        this.log = log;
        this.pedidoModel = pedidoModel;
    }


    @Override
    public Pedido inserir(Pedido pedido) {
        return pedidoModel.toPedido(pedidoDatasources.inserir(pedidoModel.toPedidoModel(pedido)));
    }

    @Override
    public List<Pedido> buscarTodos() {
        return pedidoModel.toListaPedidos(pedidoDatasources.buscarTodos());
    }

    @Override
    public Optional<Pedido> buscarStatusPagamentoPedido(String numero_pedido) {
        return pedidoDatasources.buscarStatusPagamentoPedido(numero_pedido).map(pedidoModel::toPedido);
    }

    @Override
    public Optional<Pedido> buscaPedidoNumeroPedido(String numeroPedido) {
        return Optional.of(pedidoModel.toPedido(pedidoDatasources.buscaPedidoNumeroPedido(numeroPedido).get()));
    }

    @Override
    public Pedido atualizar(Pedido pedido, String numeroPedido) {
        return null;
    }

    @Override
    public List<PedidoAcompanhamentoRequestModel> buscarPedidosAcompanhamento() {
        return null;
    }

    @Override
    public StatusPedidoTesteDTO atualizaStatusPedidoTeste(StatusPedidoTesteDTO statusPedidoTesteDTO) {
        return null;
    }
}
