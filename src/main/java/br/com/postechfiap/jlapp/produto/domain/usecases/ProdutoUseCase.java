package br.com.postechfiap.jlapp.produto.domain.usecases;

import br.com.postechfiap.jlapp.categoria.domain.entities.Categoria;
import br.com.postechfiap.jlapp.categoria.domain.repositories.CategoriaRepository;
import br.com.postechfiap.jlapp.core.shared.exception.NotFoundException;
import br.com.postechfiap.jlapp.core.shared.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import br.com.postechfiap.jlapp.produto.domain.entities.Produto;
import br.com.postechfiap.jlapp.produto.domain.repositories.ProdutoRepository;

import java.util.List;
import java.util.Objects;

public class ProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    private final CategoriaRepository categoriaRepository;

    private final Logger log;

    public ProdutoUseCase(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, Logger log) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.log = log;
    }

    public Produto inserir(Produto produto) {

        Categoria categoria = categoriaRepository.buscarCategoriaPorId(produto.getCategoria().getId()).orElseThrow(() -> new NotFoundException("Categoria com ID: " + produto.getCategoria().getId() + " não encontrada!"));

        log.info("Atribuindo {} ao novo produto!", categoria.toString());
        produto.setCategoria(categoria);

        Produto ProdutoInserir = produtoRepository.inserir(produto);
        log.info("{} salvo com sucesso!", produto.toString());
        return ProdutoInserir;
    }


    public Produto atualizar(Produto produto, Long id) {
        this.buscarProdutoPorId(id);

        Categoria categoria = categoriaRepository.buscarCategoriaPorId(produto.getCategoria().getId()).orElseThrow(() -> new NotFoundException("Categoria com ID: " + produto.getCategoria().getId() + " não encontrada!"));

        log.info("Atribuindo {} ao novo produto!", categoria.toString());
        produto.setCategoria(categoria);

        log.info("Atribuindo o ID: {} do produto que será alterado!", id);
        produto.setId(id);

        Produto produtoAtualizar = produtoRepository.atualizar(produto);
        log.info("{} alterado com sucesso!", produtoAtualizar.toString());

        return produtoAtualizar;

    }

    public void deletar(Long id) {
        this.buscarProdutoPorId(id);
        produtoRepository.deletar(id);
        log.info("Produto com ID: {} deletado com sucesso!", id);
    }


    public List<ProdutoRequestModel> buscarTodosProdutos() {
        List<Produto> produtos = produtoRepository.buscarTodosProdutos();
        if (produtos.isEmpty()) {
            throw new UnprocessableEntityException("Nenhum produto cadastrado!");
        }
        log.info("Produtos encontrados! {}", produtos);
        return produtos.stream().map(produto -> new ProdutoRequestModel().toProdutoDTO(produto)).toList();
    }

    public ProdutoRequestModel buscarProdutoPorId(Long id) {
        ProdutoRequestModel dto = new ProdutoRequestModel().toProdutoDTO(produtoRepository.buscarProdutoPorId(id)
                .orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado!")));
        log.info("Produto com ID: {} encontrado!", id);
        return dto;
    }

    public List<ProdutoRequestModel> buscarProdutosPorCategoria(Long categoriaId) {

        List<Produto> produtos = produtoRepository.buscarTodosProdutos();

        log.info("Recuperando produtos com a categoria ID: {}", categoriaId);
        produtos.removeIf(p -> !Objects.equals(p.getCategoria().getId(), categoriaId));

        if (produtos.isEmpty()) {
            throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
        }

        log.info("Produtos com a categoria ID: {} encontrados {} !", categoriaId, produtos);
        return produtos.stream().map(produto -> new ProdutoRequestModel().toProdutoDTO(produto)).toList();
    }

}
