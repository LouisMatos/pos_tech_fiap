package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.interfaces.dto.CategoriaDTO;

public interface CategoriaInputPort {

	public CategoriaDTO buscarCategoriaPorId(Long id);

}
