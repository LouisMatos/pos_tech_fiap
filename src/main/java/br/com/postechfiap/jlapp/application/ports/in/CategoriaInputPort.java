package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.CategoriaDTO;

public interface CategoriaInputPort {

	public CategoriaDTO buscarCategoriaPorId(Long id);

}
