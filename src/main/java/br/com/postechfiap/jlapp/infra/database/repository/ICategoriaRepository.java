package br.com.postechfiap.jlapp.infra.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.CategoriaEntity;

@Repository
public interface ICategoriaRepository extends JpaRepository<CategoriaEntity, Long> {

}
