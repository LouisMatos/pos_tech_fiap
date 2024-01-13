package br.com.postechfiap.jlapp.core.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.core.entities.Categoria;

public interface CategoriaOutputPort {
	
	public Optional<Categoria> buscarCategoriaPorId(Long id);
	
}
