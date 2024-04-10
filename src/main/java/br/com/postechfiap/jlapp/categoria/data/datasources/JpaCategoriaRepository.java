package br.com.postechfiap.jlapp.categoria.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;

@Repository
public interface JpaCategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}
