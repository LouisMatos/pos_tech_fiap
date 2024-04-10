package br.com.postechfiap.jlapp.produto.data.datasources.impl;

import br.com.postechfiap.jlapp.categoria.data.models.CategoriaModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.produto.data.datasources.JpaProdutoRepository;
import br.com.postechfiap.jlapp.produto.data.datasources.ProdutoDatasources;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProdutoDatasourcesImpl implements ProdutoDatasources {

	@Autowired
	private JpaProdutoRepository jpaProdutoRepository;

	@Autowired
	private Logger log;

	@Override
	public ProdutoModel inserir(ProdutoModel produtoModel) {
		log.info("Cadastrando novo produto na base de dados!");
		return jpaProdutoRepository.save(produtoModel);
	}

	@Override
	public ProdutoModel atualizar(ProdutoModel produtoModel) {
		log.info("Alterando produto na base de dados!");
		return jpaProdutoRepository.save(produtoModel);
	}

	@Override
	public void deletar(Long id) {
		log.info("Deletando produto com ID: {} na base de dados!", id);
		jpaProdutoRepository.deleteById(id);
	}

	@Override
	public List<ProdutoModel> buscarTodosProdutos() {
		log.info("Buscando todos os produtos cadastrados na base de dados!");
		return jpaProdutoRepository.findAll();
	}

	@Override
	public Optional<ProdutoModel> buscarProdutoPorId(Long id) {
		log.info("Buscando produto com o ID: {} na base de dados!", id);
		return jpaProdutoRepository.findById(id);
	}

	@Override
	public List<ProdutoModel> buscarProdutosPorCategoria(CategoriaModel categoriaModel) {
		log.info("Buscando todos os produtos cadastrados com a categoria: {} na base de dados!", categoriaModel.getNome());
		return jpaProdutoRepository.findCategoriaEntityById(categoriaModel.getId());
	}

	@Override
	public List<ProdutoModel> buscarProdutosPorCategoria(Long categoriaId) {
		log.info("Buscando produto com o ID: {} na base de dados!", categoriaId);
		return jpaProdutoRepository.findCategoriaEntityById(categoriaId);
	}

}
