package br.com.postechfiap.jlapp.infra.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.PedidoEntity;
import br.com.postechfiap.jlapp.infra.database.model.webhook.AtualizacaoStatusPagamentoEntity;

@Repository
public interface IWebhookRepository extends JpaRepository<AtualizacaoStatusPagamentoEntity, Long> {

	Optional<PedidoEntity> findByNumeroPedido(String numero_pedido);

}
