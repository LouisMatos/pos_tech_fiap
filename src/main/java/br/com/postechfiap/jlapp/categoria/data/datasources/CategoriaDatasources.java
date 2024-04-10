package br.com.postechfiap.jlapp.categoria.data.datasources;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;

import java.util.Optional;

public interface CategoriaDatasources {

	public Optional<CategoriaModel> buscarCategoriaPorId(Long id);
	
}
