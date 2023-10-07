package br.com.postechfiap.jlapp.infrastructure.adapters.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
