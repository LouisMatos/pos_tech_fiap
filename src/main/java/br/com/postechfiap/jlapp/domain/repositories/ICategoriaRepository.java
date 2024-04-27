package br.com.postechfiap.jlapp.domain.repositories;

import java.util.Optional;

import br.com.postechfiap.jlapp.domain.entities.Categoria;

public interface ICategoriaRepository {
	
	public Optional<Categoria> buscarCategoriaPorId(Long id);
	
}
