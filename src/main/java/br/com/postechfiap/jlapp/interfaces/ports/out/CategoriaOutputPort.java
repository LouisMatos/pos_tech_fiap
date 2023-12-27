package br.com.postechfiap.jlapp.application.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;

public interface CategoriaOutputPort {
	
	public Optional<Categoria> buscarCategoriaPorId(Long id);
	
}
