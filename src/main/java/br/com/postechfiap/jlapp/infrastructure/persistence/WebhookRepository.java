package br.com.postechfiap.jlapp.infrastructure.persistence;

import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import br.com.postechfiap.jlapp.webhook.data.models.AtualizacaoStatusPagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WebhookRepository extends JpaRepository<AtualizacaoStatusPagamentoModel, Long> {

	Optional<PedidoModel> findByNumeroPedido(String numero_pedido);

}
