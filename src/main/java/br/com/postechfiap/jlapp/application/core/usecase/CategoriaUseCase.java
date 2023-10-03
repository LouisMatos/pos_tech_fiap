package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.adapters.in.controller.response.CategoriaResponse;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;

public class CategoriaUseCase implements CategoriaInputPort {

	private final CategoriaOutputPort categoriaOutputPort;

	public CategoriaUseCase(CategoriaOutputPort categoriaOutputPort) {
		this.categoriaOutputPort = categoriaOutputPort;
	}

	@Override
	public CategoriaResponse buscarCategoriaPorId(Long id) {

		CategoriaResponse response = new CategoriaResponse()
				.toCategoriaResponse(categoriaOutputPort.buscarCategoriaPorId(id)
						.orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!")));

		return response;
	}

}
