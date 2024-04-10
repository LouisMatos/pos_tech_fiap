package br.com.postechfiap.jlapp.produto.data.repositories;

import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.produto.data.datasources.ProdutoDatasources;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;
import br.com.postechfiap.jlapp.produto.domain.repositories.ProdutoRepository;

import java.util.List;
import java.util.Optional;

public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoDatasources produtoDatasources;

    private final Logger log;

    public ProdutoRepositoryImpl(ProdutoDatasources produtoDatasources, Logger log) {
        this.produtoDatasources = produtoDatasources;
        this.log = log;
    }

    @Override
    public Produto inserir(Produto produto) {
        ProdutoModel produtoModel = new ProdutoModel();
        return produtoModel.toProduto(produtoDatasources.inserir(produtoModel.toProdutoModel(produto)));

    }

    @Override
    public Produto atualizar(Produto produto) {
        ProdutoModel produtoModel = new ProdutoModel();
        return produtoModel.toProduto(produtoDatasources.atualizar(produtoModel.toProdutoModel(produto)));
    }

    @Override
    public void deletar(Long id) {
        produtoDatasources.deletar(id);
    }

    @Override
    public List<Produto> buscarTodosProdutos() {
        ProdutoModel produtoModel = new ProdutoModel();
        return produtoModel.toListaProduto(produtoDatasources.buscarTodosProdutos());
    }

    @Override
    public List<Produto> buscarProdutosPorCategoria(Long categoriaId) {
        ProdutoModel produtoModel = new ProdutoModel();
        return produtoModel.toListaProduto(produtoDatasources.buscarProdutosPorCategoria(categoriaId));
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long id) {
        ProdutoModel produtoModel = new ProdutoModel();
        return produtoDatasources.buscarProdutoPorId(id).map(produtoModel::toProduto);
    }
}
