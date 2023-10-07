package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.CategoriaRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.CategoriaEntity;

@Component
public class CategoriaAdpter implements CategoriaOutputPort {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> buscarCategoriaPorId(Long id) {
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
		return categoriaEntity.map(entity -> new Categoria().toCategoria(entity));
	}

}
