package br.com.postechfiap.jlapp.infra.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.PedidoEntity;

@Repository
public interface IPedidoRepository extends JpaRepository<PedidoEntity, Long> {

	Optional<PedidoEntity> findByNumeroPedido(String numero_pedido);

}
