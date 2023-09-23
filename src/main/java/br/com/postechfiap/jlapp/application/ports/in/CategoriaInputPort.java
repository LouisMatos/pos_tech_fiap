package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;

public interface CategoriaInputPort {

	public Categoria buscarCategoriaPorId(Long id);

}
