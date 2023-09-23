package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;

public class CategoriaUseCase implements CategoriaInputPort {

	private final CategoriaOutputPort categoriaOutputPort;

	public CategoriaUseCase(CategoriaOutputPort categoriaOutputPort) {
		this.categoriaOutputPort = categoriaOutputPort;
	}

	@Override
	public Categoria buscarCategoriaPorId(Long id) {
		return categoriaOutputPort.buscarCategoriaPorId(id)
				.orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!"));
	}

}
