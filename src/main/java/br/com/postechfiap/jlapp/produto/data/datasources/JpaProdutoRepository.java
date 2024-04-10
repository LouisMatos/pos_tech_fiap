package br.com.postechfiap.jlapp.produto.data.datasources;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;

@Repository
public interface JpaProdutoRepository extends JpaRepository<ProdutoModel, Long> {

	List<ProdutoModel> findCategoriaEntityById(Long id);

}
