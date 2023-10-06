package br.com.postechfiap.jlapp.infrastructure.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.entity.ItemPedidoEntity;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedidoEntity, Long> {

}