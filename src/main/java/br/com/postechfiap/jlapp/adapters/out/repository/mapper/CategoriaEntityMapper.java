package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.CategoriaEntity;
import br.com.postechfiap.jlapp.application.core.domain.Categoria;

@Mapper(componentModel = "spring", uses = ProdutoEntityMapper.class)
public interface CategoriaEntityMapper {

	CategoriaEntity toCategoriaEntity(Categoria categoria);

	Categoria toCategoria(CategoriaEntity categoriaEntity);

}