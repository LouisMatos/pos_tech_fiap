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
	@Mapping(source = "categoria", target = "categoria.id")
	Produto toProduto(ProdutoRequest produtoRequest);

	@Mapping(source = "categoria.nome", target = "categoria")
	ProdutoResponse toProdutoResponse(Produto produto);

	
	@Mapping(source = "categoria.nome", target = "categoria")
	List<ProdutoResponse> toListProdutoResponse(List<Produto> produtos);

}