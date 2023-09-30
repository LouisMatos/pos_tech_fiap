package br.com.postechfiap.jlapp.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {

}
