package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;

public class ProdutoUseCase implements ProdutoInputPort {

	private final ProdutoOutputPort produtoOutputPort;

	public ProdutoUseCase(ProdutoOutputPort produtoOutputPort) {
		this.produtoOutputPort = produtoOutputPort;
	}

	@Override
	public void inserir(Produto produto) {
		produtoOutputPort.inserir(produto);
	}

	@Override
	public Produto atualizar(Produto produto, Long id) {
		this.buscarProdutoPorId(id);
		
		produto.setId(id);
		
		return produtoOutputPort.atualizar(produto);

	}

	@Override
	public void deletar(Long id) {
		this.buscarProdutoPorId(id);
		produtoOutputPort.deletar(id);
	}

	@Override
	public List<Produto> buscarTodosProdutos() {
		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado!");
		}
		return produtos;
	}

	@Override
	public Produto buscarProdutoPorId(Long id) {
		return produtoOutputPort.buscarProdutoPorId(id)
				.orElseThrow(() -> new NotFoundException("Produto informado não encontrado!"));
	}

}
