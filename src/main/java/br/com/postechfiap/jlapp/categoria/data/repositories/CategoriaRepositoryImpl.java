package br.com.postechfiap.jlapp.categoria.data.repositories;

import br.com.postechfiap.jlapp.categoria.data.datasources.CategoriaDatasources;
import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.categoria.domain.repositories.CategoriaRepository;
import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import br.com.postechfiap.jlapp.core.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final CategoriaDatasources categoriaDatasources;

    private final Logger log;

    public CategoriaRepositoryImpl(CategoriaDatasources categoriaDatasources, Logger log) {
        this.categoriaDatasources = categoriaDatasources;
        this.log = log;
    }

    @Override
    public Optional<Categoria> buscarCategoriaPorId(Long id) {
        CategoriaModel categoriaModel = new CategoriaModel();
        return categoriaDatasources.buscarCategoriaPorId(id).map(categoriaModel::toCategoria);
    }
}
