package br.com.postechfiap.jlapp.interfaces.ports.out;

import java.util.Optional;

import br.com.postechfiap.jlapp.application.domain.entities.Categoria;

public interface CategoriaOutputPort {
	
	public Optional<Categoria> buscarCategoriaPorId(Long id);
	
}
