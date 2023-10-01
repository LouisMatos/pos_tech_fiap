package br.com.postechfiap.jlapp.adapters.out.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ProdutoEntity;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findCategoriaEntityById(Long id);

}
