package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.domain.entities.Categoria;
import br.com.postechfiap.jlapp.interfaces.ports.out.CategoriaOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.CategoriaRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.CategoriaEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class CategoriaAdpter implements CategoriaOutputPort {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private Logger log;

	@Override
	public Optional<Categoria> buscarCategoriaPorId(Long id) {
		log.info("Buscando categoria com id - {} na base de dados!", id);
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
		return categoriaEntity.map(entity -> new Categoria().toCategoria(entity));
	}

}