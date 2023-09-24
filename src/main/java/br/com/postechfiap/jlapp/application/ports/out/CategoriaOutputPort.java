package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;

public interface CategoriaOutputPort {
	
	public Optional<Categoria> buscarCategoriaPorId(Long id);
	
}
