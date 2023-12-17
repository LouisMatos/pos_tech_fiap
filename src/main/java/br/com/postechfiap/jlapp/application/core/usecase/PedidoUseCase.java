package br.com.postechfiap.jlapp.application.core.usecase;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.enums.Estado;
import br.com.postechfiap.jlapp.application.ports.in.ClienteInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ItemPedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.PedidoInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.PedidoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ItemPedidoDTO;
import br.com.postechfiap.jlapp.interfaces.dto.PedidoDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PedidoUseCase implements PedidoInputPort {

    private final PedidoOutputPort pedidoOutputPort;
    private final ClienteInputPort clienteInputPort;
    private final ProdutoInputPort produtoInputPort;
    private final ItemPedidoInputPort itemPedidoInputPort;
    private final Logger log;

    @Override
    public PedidoDTO inserir(PedidoDTO pedidoDTO) {
        verificarCliente(pedidoDTO);
        prepararPedido(pedidoDTO);
        processarItensPedido(pedidoDTO);
        atualizarPedido(pedidoDTO);
        log.info("Pedido salvo com sucesso: {}", pedidoDTO);
        return pedidoDTO;
    }

    @Override
    public List<PedidoDTO> buscarTodos() {
        List<PedidoDTO> pedidoDTOs = pedidoOutputPort.buscarTodos().stream()
            .map(pedido -> new PedidoDTO().toPedidoDTO(pedido))
            .collect(Collectors.toList());

        pedidoDTOs.forEach(pedido -> 
            pedido.setItemPedidoDTOs(itemPedidoInputPort.buscarItemPedido(pedido.getId()))
        );

        log.info("Pedidos encontrados: {}", pedidoDTOs);
        return pedidoDTOs;
    }

    private void verificarCliente(PedidoDTO pedidoDTO) {
        if (!pedidoDTO.getClienteDTO().getCpf().isBlank()) {
            pedidoDTO.setClienteDTO(clienteInputPort.buscarClientePorCpf(pedidoDTO.getClienteDTO().getCpf()));
        } else {
            log.info("Pedido sem identificação do cliente.");
            pedidoDTO.setClienteDTO(null);
        }
    }

    private void prepararPedido(PedidoDTO pedidoDTO) {
        pedidoDTO.setEstado(Estado.RECEBIDO);
        pedidoDTO.setDataPedido(LocalDateTime.now());
    }

    private void processarItensPedido(PedidoDTO pedidoDTO) {
        pedidoDTO.getItemPedidoDTOs().forEach(this::processarItem);
        pedidoDTO.setItemPedidoDTOs(itemPedidoInputPort.inserir(pedidoDTO.getItemPedidoDTOs()));
    }

    private void processarItem(ItemPedidoDTO itemPedidoDTO) {
        itemPedidoDTO.setProdutoDTO(
            produtoInputPort.buscarProdutoPorId(itemPedidoDTO.getProdutoDTO().getId())
        );
        itemPedidoDTO.setPedidoid(pedidoDTO.getId());
    }

    private void atualizarPedido(PedidoDTO pedidoDTO) {
        pedidoDTO.setValorPedido(calcularValorTotalPedido(pedidoDTO.getItemPedidoDTOs()));
        pedidoDTO.toPedidoDTO(pedidoOutputPort.inserir(new Pedido().toPedido(pedidoDTO)));
    }

    private BigDecimal calcularValorTotalPedido(List<ItemPedidoDTO> itemPedidoDTOs) {
        BigDecimal valorPedido = itemPedidoDTOs.stream()
            .map(item -> item.getProdutoDTO().getPreco().multiply(new BigDecimal(item.getQuantidade())))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        log.info("Valor total do pedido: R$ {}", valorPedido);
        return valorPedido;
    }
}
