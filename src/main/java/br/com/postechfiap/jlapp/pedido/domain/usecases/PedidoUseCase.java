package br.com.postechfiap.jlapp.pedido.domain.usecases;

import br.com.postechfiap.jlapp.cliente.domain.repositories.ClienteRepository;
import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.core.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.pedido.data.models.StatusPedidoTesteDTO;
import br.com.postechfiap.jlapp.pedido.domain.entities.ItemPedido;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import br.com.postechfiap.jlapp.pedido.domain.entities.PedidoAcompanhamento;
import br.com.postechfiap.jlapp.pedido.domain.entities.StatusPedido;
import br.com.postechfiap.jlapp.pedido.domain.repositories.ItemPedidoRepository;
import br.com.postechfiap.jlapp.pedido.domain.repositories.PedidoRepository;
import br.com.postechfiap.jlapp.produto.domain.repositories.ProdutoRepository;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoUseCase {

    private final PedidoRepository pedidoRepository;

    private final ClienteRepository clienteRepository;

    private final ProdutoRepository produtoRepository;

    private final ItemPedidoRepository itemPedidoRepository;

    private final Logger log;

    public PedidoUseCase(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, ProdutoRepository produtoRepository, ItemPedidoRepository itemPedidoRepository, Logger log) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.itemPedidoRepository = itemPedidoRepository;
        this.log = log;
    }

    public Pedido inserir(Pedido pedido) {

        log.info("Verificando se o cliente se indentificou!");
        if (!pedido.getCliente().getCpf().isBlank()) {
            pedido.setCliente(clienteRepository.buscarClientePorCpf(pedido.getCliente().getCpf()));
        } else {
            pedido.setCliente(null);
            log.info("Pedido sem identificação do cliente!");
        }

        pedido.setEstado(Estado.RECEBIDO);
        pedido.setStatusPagamento(StatusPagamento.AGUARDANDO);
        pedido.setDataPedido(LocalDateTime.now());

        pedidoRepository.inserir(pedido);

        log.info("Processando itens do pedido!");
        for (int i = 0; i < pedido.getItens().size(); i++) {
            pedido.getItens().get(i).setProduto(
                    produtoRepository.buscarProdutoPorId(pedido.getItens().get(i).getProduto().getId()).get());
            pedido.getItens().get(i).setPedidoid(pedido.getId());
        }

        log.info("Incluindo itens ao pedido!");
        pedido.setItens(itemPedidoRepository.inserir(pedido.getItens()));

        log.info("Calculando o valor do Pedido!");
        pedido.setValorPedido(calcularValorTotalPedido(pedido.getItens()));

        log.info("Gerando numero de pedido!");
        pedido.setNumeroPedido(gerarNumeroPedido());

        pedidoRepository.inserir(pedido);
        log.info("{} salvo com sucesso!", pedido.toString());

        return pedido;

    }

    public List<Pedido> buscarTodos() {
        List<Pedido> pedidos = pedidoRepository.buscarTodos();

        for (Pedido pedido : pedidos) {
            pedido.setItens(itemPedidoRepository.buscarItemPedido(pedido.getId()));
        }

        log.info("Pedidos encontrados! {}", pedidos);
        return pedidos;
    }

    public StatusPedido buscarStatusPagamentoPedido(String numero_pedido) {

        Pedido pedido = pedidoRepository.buscarStatusPagamentoPedido(numero_pedido)
                .orElseThrow(() -> new NotFoundException("Pedido: " + numero_pedido + " não foi encontrado!"));

        log.info("Pedido encontrado! {}", pedido);

        return StatusPedido.builder().numeroPedido(pedido.getNumeroPedido()).statusPagamento(pedido.getStatusPagamento())
                .build();
    }

    public Pedido buscaPedidoNumeroPedido(String numeroPedido) {
        Pedido pedido = pedidoRepository.buscaPedidoNumeroPedido(numeroPedido)
                .orElseThrow(() -> new NotFoundException("Pedido numero " + numeroPedido + " não encontrado!"));
        log.info("Pedido: {} encontrado com sucesso!", numeroPedido);
        return pedido;
    }

    public Pedido atualizar(Pedido pedido, String numeroPedido) {
        this.buscaPedidoNumeroPedido(numeroPedido);

        log.info("Atualizando o pedido de numero: {} !", numeroPedido);
        pedido.setNumeroPedido(numeroPedido);

        pedidoRepository.atualizar(pedido);
        log.info("{} alterado com sucesso!", pedido.toString());

        return pedido;
    }

    public List<PedidoAcompanhamento> buscarPedidosAcompanhamento() {

        List<Pedido> pedidos = pedidoRepository.buscarTodos();

        List<PedidoAcompanhamento> lista = pedidos.stream()
                .map(pedido -> new PedidoAcompanhamento().toPedidoAcompanhamento(pedido))
                .collect((Collectors.toList()));
        log.info("Convertendo para o dominio de Acompanhamento de pedido!");

        lista.removeIf(t -> t.getEstado().estaFinalizado());
        log.info("Removendo os pedido em Estdo: Finalizado");

        lista.sort(Comparator.comparing(PedidoAcompanhamento::getEstado).reversed()
                .thenComparing(PedidoAcompanhamento::getDataPedido));
        log.info(
                "Ordenando pedidos na seguinte ordem [Pronto > Em Preparação > Recebido] sendo pedidos mais antigos primeiro que os mais novos");

        return lista;
    }

    public StatusPedidoTesteDTO atualizaStatusPedidoTeste(StatusPedidoTesteDTO statusPedidoTesteDTO) {

        log.info("Convertendo para o dominio de Pedido!");
        Pedido pedido = this.buscaPedidoNumeroPedido(statusPedidoTesteDTO.getNumeroPedido());

        log.info("Atualizando o pedido de numero: {} !", statusPedidoTesteDTO.getNumeroPedido());
        pedido.setEstado(statusPedidoTesteDTO.getEstado());

        pedido = pedidoRepository.atualizar(pedido);
        log.info("{} alterado com sucesso!", pedido.toString());

        return statusPedidoTesteDTO;
    }

    private BigDecimal calcularValorTotalPedido(List<ItemPedido> itemPedidos) {
        BigDecimal valorPedido = BigDecimal.ZERO;

        for (ItemPedido itemPedido : itemPedidos) {
            valorPedido = valorPedido.add(
                    itemPedido.getProduto().getPreco().multiply(new BigDecimal(itemPedido.getQuantidade())));
        }

        log.info("Valor do Pedido: R$ {}", valorPedido);
        return valorPedido;
    }

    private String gerarNumeroPedido() {
        String numeroPedido = RandomStringUtils.randomAlphanumeric(6).toUpperCase();
        log.info("Numero de Pedido: {}", numeroPedido);

        if (pedidoRepository.buscarStatusPagamentoPedido(numeroPedido).isPresent()) {
            log.info("Numero de Pedido: {} já existe gerando novo numero", numeroPedido);
            gerarNumeroPedido();
        } else {
            log.info("Numero de Pedido: {} disponivel para ser utilizado!", numeroPedido);
        }

        return numeroPedido;
    }


}
