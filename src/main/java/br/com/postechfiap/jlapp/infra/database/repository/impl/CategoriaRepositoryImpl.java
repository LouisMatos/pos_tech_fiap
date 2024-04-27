package br.com.postechfiap.jlapp.infra.database.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.Categoria;
import br.com.postechfiap.jlapp.infra.database.repository.ICategoriaRepository;
import br.com.postechfiap.jlapp.infra.database.model.CategoriaEntity;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class CategoriaRepositoryImpl implements br.com.postechfiap.jlapp.domain.repositories.ICategoriaRepository {

	@Autowired
	private ICategoriaRepository ICategoriaRepository;

	@Autowired
	private Logger log;

	@Override
	public Optional<Categoria> buscarCategoriaPorId(Long id) {
		log.info("Buscando categoria com id - {} na base de dados!", id);
		Optional<CategoriaEntity> categoriaEntity = ICategoriaRepository.findById(id);
		return categoriaEntity.map(entity -> new Categoria().toCategoria(entity));
	}

}
