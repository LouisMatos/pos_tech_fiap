package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.Objects;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ProdutoDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

public class ProdutoUseCase implements ProdutoInputPort {

	private final ProdutoOutputPort produtoOutputPort;

	private final CategoriaInputPort categoriaInputPort;

	private final Logger log;

	public ProdutoUseCase(ProdutoOutputPort produtoOutputPort, CategoriaInputPort categoriaInputPort, Logger log) {
		this.produtoOutputPort = produtoOutputPort;
		this.categoriaInputPort = categoriaInputPort;
		this.log = log;
	}

	@Override
	public ProdutoDTO inserir(ProdutoDTO produtoDTO) {

		log.info("Convertendo para o dominio de Produto!");
		Produto produto = new Produto().toProduto(produtoDTO);

		log.info("Convertendo para o dominio de Categoria!");
		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		log.info("Atribuindo {} ao novo produto!", categoria.toString());
		produto.setCategoria(categoria);

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.inserir(produto));
		log.info("{} salvo com sucesso!", dto.toString());
		return dto;
	}

	@Override
	public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Long id) {
		this.buscarProdutoPorId(id);

		log.info("Convertendo para o dominio de Produto!");
		Produto produto = new Produto().toProduto(produtoDTO);

		log.info("Convertendo para o dominio de Categoria!");
		Categoria categoria = new Categoria()
				.toCategoria(categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId()));

		log.info("Atribuindo {} ao novo produto!", categoria.toString());
		produto.setCategoria(categoria);

		log.info("Atribuindo o ID: {} do produto que será alterado!", id);
		produto.setId(id);

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.atualizar(produto));
		log.info("{} alterado com sucesso!", dto.toString());

		return dto;

	}

	@Override
	public void deletar(Long id) {
		this.buscarProdutoPorId(id);
		produtoOutputPort.deletar(id);
		log.info("Produto com ID: {} deletado com sucesso!", id);
	}

	@Override
	public List<ProdutoDTO> buscarTodosProdutos() {
		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado!");
		}
		log.info("Produtos encontrados! {}", produtos);
		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).toList();
	}

	@Override
	public ProdutoDTO buscarProdutoPorId(Long id) {
		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(produtoOutputPort.buscarProdutoPorId(id)
				.orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado!")));
		log.info("Produto com ID: {} encontrado!", id);
		return dto;
	}

	@Override
	public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId) {

		List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();

		log.info("Recuperando produtos com a categoria ID: {}", categoriaId);
		produtos.removeIf(p -> !Objects.equals(p.getCategoria().getId(), categoriaId));

		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
		}

		log.info("Produtos com a categoria ID: {} encontrados {} !", categoriaId, produtos);
		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).toList();
	}

}
