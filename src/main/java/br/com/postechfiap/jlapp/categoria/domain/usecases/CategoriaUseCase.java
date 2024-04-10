package br.com.postechfiap.jlapp.categoria.domain.usecases;

import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import br.com.postechfiap.jlapp.categoria.domain.repositories.CategoriaRepository;
import br.com.postechfiap.jlapp.core.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;

public class CategoriaUseCase {

	private final CategoriaRepository  categoriaRepository;

	private final Logger log;

    public CategoriaUseCase(CategoriaRepository categoriaRepository, Logger log) {
        this.categoriaRepository = categoriaRepository;
        this.log = log;
    }

    public Categoria buscarCategoriaPorId(Long id) {
		log.info("Verificando se a categoria está cadastrada na base");
		return categoriaRepository.buscarCategoriaPorId(id).orElseThrow(() -> new NotFoundException("Categoria informado não encontrado!"));
	}

}
