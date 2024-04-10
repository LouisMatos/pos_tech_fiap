package br.com.postechfiap.jlapp.pedido.data.datasources.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.pedido.data.datasources.ItemPedidoDatasources;
import br.com.postechfiap.jlapp.pedido.data.datasources.JpaItemPedidoRepository;
import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

@Component
public class ItemPedidoDatasourcesImpl implements ItemPedidoDatasources {

    private final JpaItemPedidoRepository jpaItemPedidoRepository;

    private final Logger log;

    public ItemPedidoDatasourcesImpl(JpaItemPedidoRepository jpaItemPedidoRepository, Logger log) {
        this.jpaItemPedidoRepository = jpaItemPedidoRepository;
        this.log = log;
    }

    @Override
    public List<ItemPedidoModel> inserir(List<ItemPedidoModel> itemPedidos) {

        List<ItemPedidoModel> list = new ArrayList<>();

        for (ItemPedidoModel itemPedidoModel : itemPedidos) {
            log.info("Cadastrando novo {} na base de dados!", itemPedidoModel);
            list.add(jpaItemPedidoRepository.save(itemPedidoModel));
        }

        return list;
    }

    @Override
    public List<ItemPedidoModel> buscarItemPedido(Long idPedido) {

        log.info("Buscando item pedido com o ID: {} na base de dados!", idPedido);
        return jpaItemPedidoRepository.findAllByPedidoid(idPedido);
    }

}
