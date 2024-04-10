package br.com.postechfiap.jlapp.cliente.data.controllers;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteResponseModel;
import br.com.postechfiap.jlapp.cliente.domain.usecases.ClienteUseCase;
import br.com.postechfiap.jlapp.core.shared.logger.log.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteRequestModel;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/api/v1/clientes")
public class ClienteController {

    private final ClienteUseCase clienteUseCase;

    private final Logger log;

    public ClienteController(ClienteUseCase clienteUseCase, Logger log) {
        this.clienteUseCase = clienteUseCase;
        this.log = log;
    }

    @PostMapping
    public ResponseEntity<ClienteRequestModel> inserir(@Valid @RequestBody ClienteRequestModel requestModel) {
        log.info("Iniciando o cadastro de cliente");
        return ResponseEntity.ok().body(ClienteResponseModel.toClienteResponse(clienteUseCase.inserir(ClienteRequestModel.toCliente(requestModel))));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteRequestModel> buscarClientePorCpf(@PathVariable final String cpf) {
        log.info("Iniciando a busca do cliente com o cpf: {}", cpf);
        return ResponseEntity.ok().body(ClienteResponseModel.toClienteResponse(clienteUseCase.buscarClientePorCpf(cpf)));
    }

}
