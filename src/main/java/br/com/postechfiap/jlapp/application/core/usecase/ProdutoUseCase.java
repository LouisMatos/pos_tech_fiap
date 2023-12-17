package br.com.postechfiap.jlapp.application.core.usecase;

import java.util.List;
import java.util.stream.Collectors;

import br.com.postechfiap.jlapp.application.core.domain.Categoria;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.exception.UnprocessableEntityException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import br.com.postechfiap.jlapp.application.ports.out.ProdutoOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.ProdutoDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProdutoUseCase implements ProdutoInputPort {

    private final ProdutoOutputPort produtoOutputPort;
    private final CategoriaInputPort categoriaInputPort;
    private final Logger log;

    @Override
    public ProdutoDTO inserir(ProdutoDTO produtoDTO) {
        Produto produto = convertToProduto(produtoDTO);
        processarCategoria(produto);
        ProdutoDTO dto = convertToProdutoDTO(produtoOutputPort.inserir(produto));
        log.info("Produto salvo com sucesso: {}", dto);
        return dto;
    }

    @Override
    public ProdutoDTO atualizar(ProdutoDTO produtoDTO, Long id) {
        verificarExistenciaProduto(id);
        Produto produto = convertToProduto(produtoDTO);
        processarCategoria(produto);
        produto.setId(id);
        ProdutoDTO dto = convertToProdutoDTO(produtoOutputPort.atualizar(produto));
        log.info("Produto atualizado com sucesso: {}", dto);
        return dto;
    }

    @Override
    public void deletar(Long id) {
        verificarExistenciaProduto(id);
        produtoOutputPort.deletar(id);
        log.info("Produto com ID: {} deletado com sucesso!", id);
    }

    @Override
    public List<ProdutoDTO> buscarTodosProdutos() {
        List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
        if (produtos.isEmpty()) {
            throw new UnprocessableEntityException("Nenhum produto cadastrado!");
        }
        log.info("Produtos encontrados: {}", produtos);
        return produtos.stream()
                       .map(this::convertToProdutoDTO)
                       .collect(Collectors.toList());
    }

    @Override
    public ProdutoDTO buscarProdutoPorId(Long id) {
        ProdutoDTO dto = produtoOutputPort.buscarProdutoPorId(id)
                .map(this::convertToProdutoDTO)
                .orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado!"));
        log.info("Produto com ID: {} encontrado!", id);
        return dto;
    }

    @Override
    public List<ProdutoDTO> buscarProdutosPorCategoria(Long categoriaId) {
        List<Produto> produtos = produtoOutputPort.buscarTodosProdutos();
        produtos.removeIf(p -> !p.getCategoria().getId().equals(categoriaId));
        if (produtos.isEmpty()) {
            throw new UnprocessableEntityException("Nenhum produto cadastrado com essa categoria!");
        }
        log.info("Produtos com a categoria ID: {} encontrados: {}", categoriaId, produtos);
        return produtos.stream()
                       .map(this::convertToProdutoDTO)
                       .collect(Collectors.toList());
    }

    private void verificarExistenciaProduto(Long id) {
        produtoOutputPort.buscarProdutoPorId(id)
                .orElseThrow(() -> new NotFoundException("Produto com ID: " + id + " não encontrado!"));
    }

    private Produto convertToProduto(ProdutoDTO produtoDTO) {
        return new Produto().toProduto(produtoDTO);
    }

    private ProdutoDTO convertToProdutoDTO(Produto produto) {
        return new ProdutoDTO().toProdutoDTO(produto);
    }

    private void processarCategoria(Produto produto) {
        Categoria categoria = categoriaInputPort.buscarCategoriaPorId(produto.getCategoria().getId())
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada!"));
        produto.setCategoria(categoria);
    }
}
