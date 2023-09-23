package br.com.postechfiap.jlapp.application.ports.out;

import java.util.List;
import java.util.Optional;

import br.com.postechfiap.jlapp.application.core.domain.Produto;

public interface ProdutoOutputPort {

	public void inserir(Produto produto);

	public Produto atualizar(Produto produto);

	public void deletar(Long id);

	public List<Produto> buscarTodosProdutos();

	public Optional<Produto> buscarProdutoPorId(Long id);

}
