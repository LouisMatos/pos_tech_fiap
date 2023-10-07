package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ProdutoDTO;

public class ProdutoUseCase implements ProdutoInputPort {

	private final ProdutoOutputPort produtoOutputPort;

	private final CategoriaInputPort categoriaInputPort;

	public ProdutoUseCase(ProdutoOutputPort produtoOutputPort, CategoriaInputPort categoriaInputPort) {
		this.produtoOutputPort = produtoOutputPort;
		this.categoriaInputPort = categoriaInputPort;
	}

	@Override
	public ProdutoDTO inserir(ProdutoDTO produtoDTO) {

		Produto produto = new Produto().toProduto(produtoDTO);

		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		produto.setCategoria(categoria);

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.inserir(produto));

		return dto;
	}

	@Override
	public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Long id) {
		this.buscarProdutoPorId(id);

		Produto produto = new Produto().toProduto(produtoDTO);

		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		produto.setCategoria(categoria);

		produto.setId(id);

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.atualizar(produto));

		return dto;

	}

	@Override
	public void deletar(Long id) {
		this.buscarProdutoPorId(id);
		produtoOutputPort.deletar(id);
	}

	@Override
	public List<ProdutoDTO> buscarTodosProdutos() {
		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado!");
		}
		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).collect(Collectors.toList());
	}

	@Override
	public ProdutoDTO buscarProdutoPorId(Long id) {
		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.buscarProdutoPorId(id)
				.orElseThrow(() -> new NotFoundException("Produto informado não encontrado!")));
		return dto;
	}

	@Override
	public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId) {

		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();

		produtos.removeIf(p -> p.getCategoria().getId() != categoriaId);

		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
		}

		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).collect(Collectors.toList());
	}

}
