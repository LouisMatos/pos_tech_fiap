package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.CategoriaDTO;

public interface CategoriaInputPort {

	public CategoriaDTO buscarCategoriaPorId(Long id);

}
