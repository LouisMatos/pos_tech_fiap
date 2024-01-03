package br.com.postechfiap.jlapp.infrastructure.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.application.domain.entities.Categoria;
import br.com.postechfiap.jlapp.application.domain.entities.Produto;
import br.com.postechfiap.jlapp.interfaces.ports.out.ProdutoOutputPort;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.ProdutoRepository;
import br.com.postechfiap.jlapp.infrastructure.adapters.repository.entity.ProdutoEntity;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;

@Component
public class ProdutoAdapter implements ProdutoOutputPort {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private Logger log;

	@Override
	public Produto inserir(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity().toProdutoEntity(produto);
		log.info("Cadastrando novo produto na base de dados!");
		return produto.toProduto(produtoRepository.save(produtoEntity));
	}

	@Override
	public Produto atualizar(Produto produto) {
		ProdutoEntity produtoEntity = new ProdutoEntity().toProdutoEntity(produto);
		log.info("Alterando produto na base de dados!");
		return produto.toProduto(produtoRepository.save(produtoEntity));
	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando produto com ID: {} na base de dados!", id);
		produtoRepository.deleteById(id);
	}

	@Override
	public List<Produto> buscarTodosProdutos() {
		log.info("Buscando todos os produtos cadastrados na base de dados!");
		List<ProdutoEntity> produtoEntity = produtoRepository.findAll();
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).collect(Collectors.toList());
	}

	@Override
	public Optional<Produto> buscarProdutoPorId(Long id) {
		log.info("Buscando produto com o ID: {} na base de dados!", id);
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		return produtoEntity.map(entity -> new Produto().toProduto(entity));
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
		log.info("Buscando todos os produtos cadastrados com a categoria: {} na base de dados!", categoria.getNome());
		List<ProdutoEntity> produtoEntity = produtoRepository.findCategoriaEntityById(categoria.getId());
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).toList();
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
		log.info("Buscando produto com o ID: {} na base de dados!", categoriaId);
		List<ProdutoEntity> produtoEntity = produtoRepository.findCategoriaEntityById(categoriaId);
		return produtoEntity.stream().map(entity -> new Produto().toProduto(entity)).toList();
	}

}