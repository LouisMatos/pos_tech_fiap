package br.com.postechfiap.jlapp.services;

import java.util.List;
import java.util.Objects;

import br.com.postechfiap.jlapp.domain.entities.Categoria;
import br.com.postechfiap.jlapp.domain.entities.Produto;
import br.com.postechfiap.jlapp.domain.interfaces.CategoriaInputPort;
import br.com.postechfiap.jlapp.domain.interfaces.ProdutoInputPort;
import br.com.postechfiap.jlapp.domain.repositories.IProdutoRespository;
import br.com.postechfiap.jlapp.domain.dtos.ProdutoDTO;
import br.com.postechfiap.jlapp.domain.exceptions.NotFoundException;
import br.com.postechfiap.jlapp.domain.exceptions.UnprocessableEntityException;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

public class ProdutoService implements ProdutoInputPort {

	private final IProdutoRespository IProdutoRespository;

	private final CategoriaInputPort categoriaInputPort;

	private final Logger log;

	public ProdutoService(IProdutoRespository IProdutoRespository, CategoriaInputPort categoriaInputPort, Logger log) {
		this.IProdutoRespository = IProdutoRespository;
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

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(IProdutoRespository.inserir(produto));
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

		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(IProdutoRespository.atualizar(produto));
		log.info("{} alterado com sucesso!", dto.toString());

		return dto;

	}

	@Override
	public void deletar(Long id) {
		this.buscarProdutoPorId(id);
		IProdutoRespository.deletar(id);
		log.info("Produto com ID: {} deletado com sucesso!", id);
	}

	@Override
	public List<ProdutoDTO> buscarTodosProdutos() {
		List<Produto> produtos = IProdutoRespository.buscarTodosProdutos();
		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado!");
		}
		log.info("Produtos encontrados! {}", produtos);
		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).toList();
	}

	@Override
	public ProdutoDTO buscarProdutoPorId(Long id) {
		ProdutoDTO dto = new ProdutoDTO().toProdutoDTO(IProdutoRespository.buscarProdutoPorId(id)
				.orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado!")));
		log.info("Produto com ID: {} encontrado!", id);
		return dto;
	}

	@Override
	public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId) {

		List<Produto> produtos = IProdutoRespository.buscarTodosProdutos();

		log.info("Recuperando produtos com a categoria ID: {}", categoriaId);
		produtos.removeIf(p -> !Objects.equals(p.getCategoria().getId(), categoriaId));

		if (produtos.isEmpty()) {
			throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
		}

		log.info("Produtos com a categoria ID: {} encontrados {} !", categoriaId, produtos);
		return produtos.stream().map(produto -> new ProdutoDTO().toProdutoDTO(produto)).toList();
	}

}
