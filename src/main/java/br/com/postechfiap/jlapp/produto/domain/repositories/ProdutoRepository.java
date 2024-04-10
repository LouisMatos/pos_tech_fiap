package br.com.postechfiap.jlapp.produto.domain.repositories;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;

public interface ProdutoRepository {

	public Produto inserir(Produto produto);

	public Produto atualizar(Produto produto);

	public void deletar(Long id);

	public List<Produto> buscarTodosProdutos();

	public List<Produto> buscarProdutosPorCategoria(Long categoriaId);

	public Optional<Produto> buscarProdutoPorId(Long id);

}
