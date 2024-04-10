package br.com.postechfiap.jlapp.produto.data.datasources;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;

public interface ProdutoDatasources {

	public ProdutoModel inserir(ProdutoModel produtoModel);

	public ProdutoModel atualizar(ProdutoModel produtoModel);

	public void deletar(Long id);

	public List<ProdutoModel> buscarTodosProdutos();
	
	public List<ProdutoModel> buscarProdutosPorCategoria(CategoriaModel categoriaModel);

	public Optional<ProdutoModel> buscarProdutoPorId(Long id);

	public List<ProdutoModel> buscarProdutosPorCategoria(Long categoriaId);

}
