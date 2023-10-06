package br.com.postechfiap.jlapp.adapters.in.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.adapters.in.controller.dto.ProdutoDTO;
import br.com.postechfiap.jlapp.application.ports.in.ProdutoInputPort;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoInputPort produtoInputPort;

	@PostMapping
	public ResponseEntity<ProdutoDTO> inserirProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
		return ResponseEntity.ok().body(produtoInputPort.inserir(produtoDTO));
	}

	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
		return ResponseEntity.ok().body(produtoInputPort.buscarTodosProdutos());
	}

	@GetMapping("/{id}/categoria")
	public ResponseEntity<List<ProdutoDTO>> buscarProdutosPorCategoria(@PathVariable Long id) {
		return ResponseEntity.ok().body(produtoInputPort.buscarProdutosPorCategoria(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> atualizarProduto(@Valid @RequestBody ProdutoDTO produtoDTO,
			@PathVariable Long id) {
		return ResponseEntity.ok().body(produtoInputPort.atualizar(produtoDTO, id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {
		produtoInputPort.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
