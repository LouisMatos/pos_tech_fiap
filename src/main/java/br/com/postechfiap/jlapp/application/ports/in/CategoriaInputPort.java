package br.com.postechfiap.jlapp.application.ports.in;

import br.com.postechfiap.jlapp.adapters.in.controller.response.CategoriaResponse;

public interface CategoriaInputPort {

	public CategoriaResponse buscarCategoriaPorId(Long id);

}
