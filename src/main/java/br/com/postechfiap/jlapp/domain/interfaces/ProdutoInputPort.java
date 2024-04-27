package br.com.postechfiap.jlapp.domain.interfaces;

import java.util.List;

import br.com.postechfiap.jlapp.domain.dtos.ProdutoDTO;

public interface ProdutoInputPort {

	public ProdutoDTO inserir(ProdutoDTO produtoDTO);

	public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Long id);

	public void deletar(Long id);

	public List<ProdutoDTO> buscarTodosProdutos();

	public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId);

	public ProdutoDTO buscarProdutoPorId(Long id);

}
