package br.com.postechfiap.jlapp.pedido.domain.usecases;

import java.util.List;

import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.pedido.domain.repositories.ItemPedidoRepository;
import br.com.postechfiap.jlapp.pedido.data.datasources.ItemPedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoRequestModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

public class ItemPedidoUseCase {

    private final ItemPedidoRepository itemPedidoRepository;

    private final Logger log;

    public ItemPedidoUseCase(ItemPedidoRepository itemPedidoRepository, Logger log) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.log = log;
    }

    public List<ItemPedido> inserir(List<ItemPedidoRequestModel> dtos) {
        log.info("Convertendo para o dominio de Item Pedido!");
        List<ItemPedido> itemPedidos = itemPedidoRepository.inserir(dtos.stream().map(it -> new ItemPedido().toItemPedido(it)).toList());

        log.info("{} salvos com sucesso!", itemPedidos);
        return itemPedidos;
    }

    public List<ItemPedido> buscarItemPedido(Long idPedido) {
        List<ItemPedido> itemPedidos = itemPedidoRepository.buscarItemPedido(idPedido);

        log.info("Itens Pedido com o pedido ID: {} encontrados {} !", idPedido, itemPedidos);
        return itemPedidos;

    }
}
