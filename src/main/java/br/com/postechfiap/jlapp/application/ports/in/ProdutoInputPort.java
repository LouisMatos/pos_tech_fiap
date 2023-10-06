package br.com.postechfiap.jlapp.application.ports.in;

import java.util.List;

import br.com.postechfiap.jlapp.interfaces.adapters.in.controller.dto.ProdutoDTO;

public interface ProdutoInputPort {

	public ProdutoDTO inserir(ProdutoDTO produtoDTO);

	public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Long id);

	public void deletar(Long id);

	public List<ProdutoDTO> buscarTodosProdutos();

	public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId);

	public ProdutoDTO buscarProdutoPorId(Long id);

}
