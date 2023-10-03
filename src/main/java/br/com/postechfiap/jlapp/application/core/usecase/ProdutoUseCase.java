package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ProdutoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ProdutoResponse;
import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;

public class ProdutoUseCase implements ProdutoInputPort {

	private final ProdutoOutputPort produtoOutputPort;

	private final CategoriaInputPort categoriaInputPort;

	public ProdutoUseCase(ProdutoOutputPort produtoOutputPort, CategoriaInputPort categoriaInputPort) {
		this.produtoOutputPort = produtoOutputPort;
		this.categoriaInputPort = categoriaInputPort;
	}

	@Override
	public ProdutoResponse inserir(ProdutoRequest produtoRequest) {

		Produto produto = new Produto().toProduto(produtoRequest);

		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		produto.setCategoria(categoria);

		ProdutoResponse response = new ProdutoResponse().toProdutoResponse(produtoOutputPort.inserir(produto));

		return response;
	}

	@Override
	public ProdutoResponse atualizar(ProdutoRequest produtoRequest, Long id) {
		this.buscarProdutoPorId(id);

		Produto produto = new Produto().toProduto(produtoRequest);
		
		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		produto.setCategoria(categoria);

		produto.setId(id);

		ProdutoResponse response = new ProdutoResponse().toProdutoResponse(produtoOutputPort.atualizar(produto));

		return response;

	}

	@Override
	public void deletar(Long id) {
		this.buscarProdutoPorId(id);
		produtoOutputPort.deletar(id);
	}

	@Override
	public List<ProdutoResponse> buscarTodosProdutos() {
		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado!");
		}
		return produtos.stream().map(produto -> new ProdutoResponse().toProdutoResponse(produto))
				.collect(Collectors.toList());
	}

	@Override
	public ProdutoResponse buscarProdutoPorId(Long id) {
		ProdutoResponse response = new ProdutoResponse().toProdutoResponse(produtoOutputPort.buscarProdutoPorId(id)
				.orElseThrow(() -> new NotFoundException("Produto informado não encontrado!")));
		return response;
	}

	@Override
	public List<ProdutoResponse> buscarProdutosPorCategoria(Long categoriaId) {

		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();

		produtos.removeIf(p -> p.getCategoria().getId() != categoriaId);

		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
		}

		return produtos.stream().map(produto -> new ProdutoResponse().toProdutoResponse(produto))
				.collect(Collectors.toList());
	}

}
