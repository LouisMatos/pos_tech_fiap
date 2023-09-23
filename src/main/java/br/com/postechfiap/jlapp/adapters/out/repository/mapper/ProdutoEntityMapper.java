package br.com.postechfiap.jlapp.adapters.out.repository.mapper;

import org.mapstruct.Mapper;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ProdutoEntity;
import br.com.postechfiap.jlapp.application.core.domain.Produto;

@Mapper(componentModel = "spring")
public interface ProdutoEntityMapper {

	ProdutoEntity toProdutoEntity(Produto produto);

	Produto toProduto(ProdutoEntity produtoEntity);

}