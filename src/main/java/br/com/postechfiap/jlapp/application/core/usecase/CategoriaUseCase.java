package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;
import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.CategoriaDTO;

public class CategoriaUseCase implements CategoriaInputPort {

	private final CategoriaOutputPort categoriaOutputPort;

	public CategoriaUseCase(CategoriaOutputPort categoriaOutputPort) {
		this.categoriaOutputPort = categoriaOutputPort;
	}

	@Override
	public CategoriaDTO buscarCategoriaPorId(Long id) {
		CategoriaDTO categoriaDTO = new CategoriaDTO().toCategoriaDTO(categoriaOutputPort.buscarCategoriaPorId(id)
				.orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!")));
		return categoriaDTO;
	}

}
