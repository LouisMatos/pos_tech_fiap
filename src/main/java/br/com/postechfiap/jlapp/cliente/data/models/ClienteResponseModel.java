package br.com.postechfiap.jlapp.cliente.data.models;

import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class ClienteResponseModel {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @Email
    @JsonProperty("email")
    private String email;

    public static ClienteRequestModel toClienteResponse(Cliente Cliente) {
        ClienteRequestModel cliente = new ClienteRequestModel();
        cliente.setId(Cliente.getId());
        cliente.setNome(Cliente.getNome());
        cliente.setCpf(Cliente.getCpf());
        cliente.setEmail(Cliente.getEmail());
        return cliente;
    }
}
