package br.com.postechfiap.jlapp.domain.interfaces;

import br.com.postechfiap.jlapp.domain.dtos.CategoriaDTO;

public interface CategoriaInputPort {

	public CategoriaDTO buscarCategoriaPorId(Long id);

}
