package br.com.postechfiap.jlapp.produto.data.controllers;

import br.com.postechfiap.jlapp.produto.data.models.ProdutoResponseModel;
import br.com.postechfiap.jlapp.produto.domain.repositories.ProdutoRepository;
import br.com.postechfiap.jlapp.produto.data.models.ProdutoRequestModel;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import br.com.postechfiap.jlapp.produto.domain.usecases.ProdutoUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    private final Logger log;

    public ProdutoController(ProdutoUseCase produtoUseCase, Logger log) {
        this.produtoUseCase = produtoUseCase;
        this.log = log;
    }


    @PostMapping
    public ResponseEntity<ProdutoResponseModel> inserirProduto(@Valid @RequestBody ProdutoRequestModel produtoRequestModel) {
        log.info("Iniciando o cadastro de Produto");
        ProdutoResponseModel produtoResponseModel = ProdutoResponseModel.toProdutoResponseModel(produtoUseCase.inserir(ProdutoRequestModel.toProduto(produtoRequestModel)));
        return ResponseEntity.ok().body(produtoResponseModel);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseModel>> buscarTodosProdutos() {
        log.info("Iniciando a busca de todos os Produtos");
        List<ProdutoResponseModel> produtoRequestModels = ProdutoResponseModel.toListaProdutoResponseModel(produtoUseCase.buscarTodosProdutos());
        return ResponseEntity.ok().body(produtoRequestModels);
    }

    @GetMapping("/{id}/categoria")
    public ResponseEntity<List<ProdutoResponseModel>> buscarProdutosPorCategoria(@PathVariable Long id) {
        log.info("Iniciando a busca de todos os Produtos da mesma Categoria");
        List<ProdutoResponseModel> produtoRequestModels = ProdutoResponseModel.toListaProdutoResponseModel(produtoUseCase.buscarProdutosPorCategoria(id));
        return ResponseEntity.ok().body(produtoRequestModels);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseModel> atualizarProduto(@Valid @RequestBody ProdutoRequestModel produtoRequestModel,
                                                                 @PathVariable Long id) {
        log.info("Iniciando a atualização de Produto");
        ProdutoResponseModel produtoResponseModel = ProdutoResponseModel.toProdutoResponseModel(produtoUseCase.atualizar(ProdutoRequestModel.toProduto(produtoRequestModel), id));
        return ResponseEntity.ok().body(produtoResponseModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
        log.info("Iniciando a deleção de Produto");
        produtoUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
