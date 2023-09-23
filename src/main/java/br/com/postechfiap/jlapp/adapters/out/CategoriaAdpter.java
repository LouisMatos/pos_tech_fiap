package br.com.postechfiap.jlapp.adapters.out;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.CategoriaRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.CategoriaEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.CategoriaEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;

@Component
public class CategoriaAdpter implements CategoriaOutputPort {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private CategoriaEntityMapper categoriaEntityMapper;

	@Override
	public Optional<Categoria> buscarCategoriaPorId(Long id) {
		Optional<CategoriaEntity> categoriaEntity = categoriaRepository.findById(id);
		return categoriaEntity.map(entity -> categoriaEntityMapper.toCategoria(entity));
	}

}
