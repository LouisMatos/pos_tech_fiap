package br.com.postechfiap.jlapp.infrastructure.adapters.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findCategoriaEntityById(Long id);

}
