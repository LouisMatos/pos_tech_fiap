package br.com.postechfiap.jlapp.pedido.data.repositories;

import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.pedido.data.datasources.ItemPedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.datasources.PedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoAcompanhamentoRequestModel;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import br.com.postechfiap.jlapp.pedido.data.models.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import br.com.postechfiap.jlapp.pedido.domain.repositories.ItemPedidoRepository;
import br.com.postechfiap.jlapp.pedido.domain.repositories.PedidoRepository;
import br.com.postechfiap.jlapp.webhook.data.models.StatusPedidoRequestModel;

import java.util.List;
import java.util.stream.Collectors;

public class ItemPedidoRepositoryImpl implements ItemPedidoRepository {

    private final ItemPedidoDatasources itemPedidoDatasources;

    private final Logger log;

    private final ItemPedidoModel itemPedidoModel;


    public ItemPedidoRepositoryImpl(ItemPedidoDatasources itemPedidoDatasources, Logger log, ItemPedidoModel itemPedidoModel) {
        this.itemPedidoDatasources = itemPedidoDatasources;
        this.log = log;
        this.itemPedidoModel = itemPedidoModel;
    }

    @Override
    public List<ItemPedido> inserir(List<ItemPedido> itemPedidos) {
        List<ItemPedidoModel> itemPedidoModels = itemPedidos.stream()
                .map(itemPedidoModel::toItemPedidoModel)
                .collect(Collectors.toList());

        List<ItemPedidoModel> insertedItemPedidoModels = itemPedidoDatasources.inserir(itemPedidoModels);

        return itemPedidoModel.toListaItemPedido(insertedItemPedidoModels);
    }

    @Override
    public List<ItemPedido> buscarItemPedido(Long idPedido) {
        return itemPedidoModel.toListaItemPedido(itemPedidoDatasources.buscarItemPedido(idPedido));
    }
}
