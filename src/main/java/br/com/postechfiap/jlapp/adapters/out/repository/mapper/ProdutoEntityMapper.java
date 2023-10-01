package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ProdutoEntity;
import br.com.postechfiap.jlapp.application.core.domain.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

	@Mapping(source = "categoria", target = "categoriaEntity")
	ProdutoEntity toProdutoEntity(Produto produto);

	@InheritInverseConfiguration
	@Mapping(source = "categoriaEntity", target = "categoria")
	Produto toProduto(ProdutoEntity produtoEntity);

}