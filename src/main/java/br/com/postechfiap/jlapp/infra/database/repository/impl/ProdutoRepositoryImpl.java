package br.com.postechfiap.jlapp.infra.database.repository.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.domain.entities.Categoria;
import br.com.postechfiap.jlapp.domain.entities.Produto;
import br.com.postechfiap.jlapp.domain.repositories.IProdutoRespository;
import br.com.postechfiap.jlapp.infra.database.repository.IProdutoRepository;
import br.com.postechfiap.jlapp.infra.database.model.ProdutoEntity;
import br.com.postechfiap.jlapp.infra.logger.log.Logger;

@Component
public class ProdutoRepositoryImpl implements IProdutoRespository {

	@Autowired
	private IProdutoRepository IProdutoRepository;

	@Autowired
	private Logger log;

	@Override
	public Produto inserir(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity().toProdutoEntity(produto);
		log.info("Cadastrando novo produto na base de dados!");
		return produto.toProduto(IProdutoRepository.save(produtoEntity));
	}

	@Override
	public Produto atualizar(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity().toProdutoEntity(produto);
		log.info("Alterando produto na base de dados!");
		return produto.toProduto(IProdutoRepository.save(produtoEntity));
	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando produto com ID: {} na base de dados!", id);
		IProdutoRepository.deleteById(id);
	}

	@Override
	public List<Produto> buscarTodosProdutos() {
		log.info("Buscando todos os produtos cadastrados na base de dados!");
		List<ProdutoEntity> produtoEntity = IProdutoRepository.findAll();
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).collect(Collectors.toList());
	}

	@Override
	public Optional<Produto> buscarProdutoPorId(Long id) {
		log.info("Buscando produto com o ID: {} na base de dados!", id);
		Optional<ProdutoEntity> produtoEntity = IProdutoRepository.findById(id);
		return produtoEntity.map(entity -> new Produto().toProduto(entity));
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
		log.info("Buscando todos os produtos cadastrados com a categoria: {} na base de dados!", categoria.getNome());
		List<ProdutoEntity> produtoEntity = IProdutoRepository.findCategoriaEntityById(categoria.getId());
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).toList();
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
		log.info("Buscando produto com o ID: {} na base de dados!", categoriaId);
		List<ProdutoEntity> produtoEntity = IProdutoRepository.findCategoriaEntityById(categoriaId);
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).toList();
	}

}
