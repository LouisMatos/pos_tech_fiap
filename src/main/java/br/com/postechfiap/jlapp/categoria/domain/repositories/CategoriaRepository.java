package br.com.postechfiap.jlapp.categoria.domain.repositories;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaRequestModel;
import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;

import java.util.Optional;

public interface CategoriaRepository {

	public Optional<Categoria> buscarCategoriaPorId(Long id);

}
