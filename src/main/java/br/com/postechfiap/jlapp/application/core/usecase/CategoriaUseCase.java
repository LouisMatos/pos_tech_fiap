package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.CategoriaDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

public class CategoriaUseCase implements CategoriaInputPort {

	private final CategoriaOutputPort categoriaOutputPort;

	private final Logger log;

	public CategoriaUseCase(CategoriaOutputPort categoriaOutputPort, Logger log) {
		this.categoriaOutputPort = categoriaOutputPort;
		this.log = log;
	}

	@Override
	public CategoriaDTO buscarCategoriaPorId(Long id) {
		log.info("Verificando se a categoria está cadastrada na base");
		return new CategoriaDTO().toCategoriaDTO(categoriaOutputPort.buscarCategoriaPorId(id)
				.orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!")));
	}

}
