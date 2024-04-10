package br.com.postechfiap.jlapp.pedido.data.datasources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.pedido.data.models.ItemPedidoModel;

@Repository
public interface JpaItemPedidoRepository extends JpaRepository<ItemPedidoModel, Long> {

	List<ItemPedidoModel> findAllByPedidoid(Long idPedido);

}