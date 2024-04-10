package br.com.postechfiap.jlapp.pedido.data.models;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteModel;
import br.com.postechfiap.jlapp.pedido.domain.entities.Pedido;
import br.com.postechfiap.jlapp.core.enums.Estado;
import br.com.postechfiap.jlapp.core.enums.StatusPagamento;
import br.com.postechfiap.jlapp.pedido.domain.entities.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pedidos")
public class PedidoModel implements Serializable {

    private static final long serialVersionUID = 106181416585362479L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    private Long id;

    private String numeroPedido;

    @Enumerated
    private StatusPagamento statusPagamento;

    @ManyToOne(optional = true, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, name = "id_cliente")
    private ClienteModel clienteModel;

    @OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, mappedBy = "pedidoEntity")
    private List<ItemPedidoModel> itemPedidoEntities;

    @Enumerated
    private Estado estado;

    private LocalDateTime dataPedido;

    private BigDecimal valorPedido;


    public PedidoModel toPedidoModel(Pedido pedido) {
        this.id = pedido.getId();
        this.numeroPedido = pedido.getNumeroPedido();
        this.statusPagamento = pedido.getStatusPagamento();
        this.clienteModel = new ClienteModel().toClienteModel(pedido.getCliente());
        this.itemPedidoEntities = pedido.getItens().stream().map(itemPedido -> new ItemPedidoModel().toItemPedidoModel(itemPedido)).toList();
        this.estado = pedido.getEstado();
        this.dataPedido = pedido.getDataPedido();
        this.valorPedido = pedido.getValorPedido();
        return this;
    }

    public Pedido toPedido(PedidoModel pedidoModel) {
        Pedido pedido = new Pedido();
        pedido.setId(pedidoModel.getId());
        pedido.setNumeroPedido(pedidoModel.getNumeroPedido());
        pedido.setStatusPagamento(pedidoModel.getStatusPagamento());
        pedido.setCliente(pedidoModel.getClienteModel().toCliente(pedidoModel.getClienteModel()));
        pedido.setItens(pedidoModel.getItemPedidoEntities().stream().map(itemPedidoModel -> new ItemPedidoModel().toItemPedido(itemPedidoModel)).toList());
        pedido.setEstado(pedidoModel.getEstado());
        pedido.setDataPedido(pedidoModel.getDataPedido());
        pedido.setValorPedido(pedidoModel.getValorPedido());
        return pedido;

    }

    public List<Pedido> toListaPedidos(List<PedidoModel> pedidoModels) {
        return pedidoModels.stream().map(this::toPedido).toList();
    }

    public StatusPedido toStatusPedido(PedidoModel pedidoModel) {
        return StatusPedido.builder().numeroPedido(pedidoModel.getNumeroPedido()).statusPagamento(pedidoModel.getStatusPagamento()).build();
    }
}
