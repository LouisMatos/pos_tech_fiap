package br.com.postechfiap.jlapp.core.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.core.entities.Categoria;
import br.com.postechfiap.jlapp.core.entities.Produto;

public interface ProdutoOutputPort {

	public Produto inserir(Produto produto);

	public Produto atualizar(Produto produto);

	public void deletar(Long id);

	public List<Produto> buscarTodosProdutos();
	
	public List<Produto> buscarProdutosPorCategoria(Categoria categoria);

	public Optional<Produto> buscarProdutoPorId(Long id);

	public List<Produto> buscarProdutosPorCategoria(Long categoriaId);

}
