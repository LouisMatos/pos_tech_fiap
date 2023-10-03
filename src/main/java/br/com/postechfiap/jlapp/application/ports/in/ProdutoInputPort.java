package br.com.postechfiap.jlapp.application.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.adapters.in.controller.request.ProdutoRequest;
import br.com.postechfiap.jlapp.adapters.in.controller.response.ProdutoResponse;

public interface ProdutoInputPort {

	public ProdutoResponse inserir(ProdutoRequest produtoRequest);

	public ProdutoResponse atualizar(ProdutoRequest produtoRequest, Long id);

	public void deletar(Long id);

	public List<ProdutoResponse> buscarTodosProdutos();

	public List<ProdutoResponse> buscarProdutosPorCategoria(Long categoriaId);

	public ProdutoResponse buscarProdutoPorId(Long id);

}
