package br.com.postechfiap.jlapp.adapters.out;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.postechfiap.jlapp.adapters.out.repository.ProdutoRepository;
import br.com.postechfiap.jlapp.adapters.out.repository.entity.ProdutoEntity;
import br.com.postechfiap.jlapp.adapters.out.repository.mapper.ProdutoEntityMapper;
import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;

@Component
public class ProdutoAdapter implements ProdutoOutputPort {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoEntityMapper produtoEntityMapper;

	@Override
	public Produto inserir(Produto produto) {
		ProdutoEntity produtoEntity = produtoEntityMapper.toProdutoEntity(produto);
		
		ProdutoEntity salvado = produtoRepository.save(produtoEntity);
		
		return produtoEntityMapper.toProduto(salvado);
	}

	@Override
	public Produto atualizar(Produto produto) {
		ProdutoEntity produtoEntity = produtoEntityMapper.toProdutoEntity(produto);
		return produtoEntityMapper.toProduto(produtoRepository.save(produtoEntity));
	}

	@Override
	public void deletar(Long id) {
		produtoRepository.deleteById(id);
	}

	@Override
	public List<Produto> buscarTodosProdutos() {
		List<ProdutoEntity> produtoEntity = produtoRepository.findAll();
		return produtoEntity.stream().map(entity -> produtoEntityMapper.toProduto(entity)).collect(Collectors.toList());
	}

	@Override
	public Optional<Produto> buscarProdutoPorId(Long id) {
		Optional<ProdutoEntity> produtoEntity = produtoRepository.findById(id);
		return produtoEntity.map(entity -> produtoEntityMapper.toProduto(entity));
	}

	@Override
	public List<Produto> buscarProdutosPorCategoria(Categoria categoria) {
		List<ProdutoEntity> produtoEntity = produtoRepository.findCategoriaEntityById(categoria.getId());
		return produtoEntity.stream().map(entity -> produtoEntityMapper.toProduto(entity)).collect(Collectors.toList());
	}

}
