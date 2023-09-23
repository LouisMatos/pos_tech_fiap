package br.com.postechfiap.jlapp.adapters.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
