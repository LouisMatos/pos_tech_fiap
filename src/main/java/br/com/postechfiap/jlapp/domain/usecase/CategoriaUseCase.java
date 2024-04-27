package br.com.postechfiap.jlapp.domain.usecase;

import br.com.postechfiap.jlapp.domain.dtos.CategoriaDTO;
import br.com.postechfiap.jlapp.domain.entities.Categoria;
import br.com.postechfiap.jlapp.domain.exceptions.NotFoundException;
import br.com.postechfiap.jlapp.domain.mappers.CategoriaMapper;
import br.com.postechfiap.jlapp.domain.repositories.ICategoriaRepository;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

public class CategoriaUseCase {

	private final ICategoriaRepository ICategoriaRepository;

	private final Logger log;

	public CategoriaUseCase(ICategoriaRepository ICategoriaRepository, Logger log) {
		this.ICategoriaRepository = ICategoriaRepository;
		this.log = log;
	}

	public CategoriaDTO executeBuscaPorId(Long id) {

		log.info("Verificando se a categoria está cadastrada na base");

		Categoria categoria = ICategoriaRepository.buscarCategoriaPorId(id).orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!"));

		return CategoriaMapper.toDTO(categoria);
	}

}
