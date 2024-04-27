package br.com.postechfiap.jlapp.services;

import br.com.postechfiap.jlapp.domain.interfaces.CategoriaInputPort;
import br.com.postechfiap.jlapp.domain.repositories.ICategoriaRepository;
import br.com.postechfiap.jlapp.domain.dtos.CategoriaDTO;
import br.com.postechfiap.jlapp.domain.exceptions.NotFoundException;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

public class CategoriaService implements CategoriaInputPort {

	private final ICategoriaRepository ICategoriaRepository;

	private final Logger log;

	public CategoriaService(ICategoriaRepository ICategoriaRepository, Logger log) {
		this.ICategoriaRepository = ICategoriaRepository;
		this.log = log;
	}

	@Override
	public CategoriaDTO buscarCategoriaPorId(Long id) {
		log.info("Verificando se a categoria está cadastrada na base");
		return new CategoriaDTO().toCategoriaDTO(ICategoriaRepository.buscarCategoriaPorId(id)
				.orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!")));
	}

}
