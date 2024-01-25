package br.com.postechfiap.jlapp.core.ports.in;

import br.com.postechfiap.jlapp.infrastructure.controllers.dto.CategoriaDTO;

public interface CategoriaInputPort {

	public CategoriaDTO buscarCategoriaPorId(Long id);

}
