package br.com.postechfiap.jlapp.cliente.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ClienteRequestModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @Email
    @JsonProperty("email")
    private String email;

    public static Cliente toCliente(ClienteRequestModel requestModel) {
        Cliente cliente = new Cliente();
        cliente.setId(requestModel.getId());
        cliente.setNome(requestModel.getNome());
        cliente.setCpf(requestModel.getCpf());
        cliente.setEmail(requestModel.getEmail());
        return cliente;
    }

    public static ClienteRequestModel toClienteRequestModel(Cliente cliente) {
        ClienteRequestModel requestModel = new ClienteRequestModel();
        requestModel.setId(cliente.getId());
        requestModel.setNome(cliente.getNome());
        requestModel.setCpf(cliente.getCpf());
        requestModel.setEmail(cliente.getEmail());
        return requestModel;
    }
}
