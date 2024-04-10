package br.com.postechfiap.jlapp.pedido.data.datasources;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaPedidoRepository extends JpaRepository<PedidoModel, Long> {

	Optional<PedidoModel> findByNumeroPedido(String numero_pedido);

}
