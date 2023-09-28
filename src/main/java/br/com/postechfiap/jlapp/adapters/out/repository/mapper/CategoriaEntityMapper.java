package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.CategoriaEntity;
import br.com.postechfiap.jlapp.application.core.domain.Categoria;

@Mapper(componentModel = "spring", uses = { ProdutoEntityMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaEntityMapper {

	@Mapping(source = "produtos", target = "produtoEntities")
	CategoriaEntity toCategoriaEntity(Categoria categoria);

	@Mapping(source = "produtoEntities", target = "produtos")
	Categoria toCategoria(CategoriaEntity categoriaEntity);

}