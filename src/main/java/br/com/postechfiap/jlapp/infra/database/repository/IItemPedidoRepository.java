package br.com.postechfiap.jlapp.infra.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.ItemPedidoEntity;

@Repository
public interface IItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {

	List<ItemPedidoEntity> findAllByPedidoid(Long idPedido);

}