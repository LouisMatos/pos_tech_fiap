package br.com.postechfiap.jlapp.infra.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.ProdutoEntity;

@Repository
public interface IProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

	List<ProdutoEntity> findCategoriaEntityById(Long id);

}
