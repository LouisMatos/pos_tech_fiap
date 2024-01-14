package br.com.postechfiap.jlapp.infrastructure.persistence;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infrastructure.persistence.entity.PedidoEntity;
import br.com.postechfiap.jlapp.infrastructure.persistence.entity.webhook.AtualizacaoStatusPagamentoEntity;

@Repository
public interface WebhookRepository extends JpaRepository<AtualizacaoStatusPagamentoEntity, Long> {

	Optional<PedidoEntity> findByNumeroPedido(String numero_pedido);

}
