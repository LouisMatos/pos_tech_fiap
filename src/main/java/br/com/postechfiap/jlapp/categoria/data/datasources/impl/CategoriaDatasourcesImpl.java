package br.com.postechfiap.jlapp.categoria.data.datasources.impl;

import br.com.postechfiap.jlapp.categoria.data.datasources.CategoriaDatasources;
import br.com.postechfiap.jlapp.categoria.data.datasources.JpaCategoriaRepository;
import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaDatasourcesImpl implements CategoriaDatasources {

    private final JpaCategoriaRepository jpaCategoriaRepository;

    private final Logger log;

    public CategoriaDatasourcesImpl(JpaCategoriaRepository jpaCategoriaRepository, Logger log) {
        this.jpaCategoriaRepository = jpaCategoriaRepository;
        this.log = log;
    }

    @Override
    public Optional<CategoriaModel> buscarCategoriaPorId(Long id) {
        log.info("Buscando categoria com id - {} na base de dados!", id);
        return jpaCategoriaRepository.findById(id);
    }

}
