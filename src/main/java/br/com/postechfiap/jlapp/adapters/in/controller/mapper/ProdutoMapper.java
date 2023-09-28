package br.com.postechfiap.jlapp.adapters.in.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ProdutoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ProdutoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Produto;


@Mapper(componentModel = "spring")
public interface ProdutoMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "categoria", ignore = true)
	Produto toProduto(ProdutoRequest produtoRequest);

//	@Mapping(source = "categoria.id", target = "categoria")
	ProdutoResponse toProdutoResponse(Produto produto);

	List<ProdutoResponse> toListProdutoResponse(List<Produto> produto);

}