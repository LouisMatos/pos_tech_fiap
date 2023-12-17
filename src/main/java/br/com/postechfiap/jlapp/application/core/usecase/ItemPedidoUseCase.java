package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ItemPedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ItemPedidoUseCase implements ItemPedidoInputPort {

    private final ItemPedidoOutputPort itemPedidoOutputPort;
    private final Logger log;

    @Override
    public List<ItemPedidoDTO> inserir(List<ItemPedidoDTO> dtos) {
        log.info("Convertendo DTOs para o domínio de ItemPedido e salvando");
        List<ItemPedido> itemPedidos = dtos.stream()
                                           .map(this::convertToItemPedido)
                                           .collect(Collectors.toList());

        List<ItemPedido> savedItemPedidos = itemPedidoOutputPort.inserir(itemPedidos);
        log.info("Itens de pedido salvos com sucesso");

        return savedItemPedidos.stream()
                               .map(this::convertToItemPedidoDTO)
                               .collect(Collectors.toList());
    }

    @Override
    public List<ItemPedidoDTO> buscarItemPedido(Long idPedido) {
        List<ItemPedido> itemPedidos = itemPedidoOutputPort.buscarItemPedido(idPedido);
        log.info("Itens de pedido encontrados para o pedido ID: {}", idPedido);

        return itemPedidos.stream()
                          .map(this::convertToItemPedidoDTO)
                          .collect(Collectors.toList());
    }

    private ItemPedido convertToItemPedido(ItemPedidoDTO dto) {
        return new ItemPedido().toItemPedido(dto);
    }

    private ItemPedidoDTO convertToItemPedidoDTO(ItemPedido itemPedido) {
        return new ItemPedidoDTO().toItemPedidoDTO(itemPedido);
    }
}
