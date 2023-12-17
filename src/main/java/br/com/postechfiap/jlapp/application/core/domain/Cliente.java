package br.com.postechfiap.jlapp.application.core.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Objects;

/**
 * Representa um cliente no domínio da aplicação.
 * Contém informações pessoais e os pedidos associados ao cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private List<Pedido> pedidos;

    /**
     * Define o nome do cliente.
     *
     * @param nome O nome do cliente.
     * @throws NullPointerException se o nome for nulo.
     */
    public void setNome(String nome) {
        this.nome = Objects.requireNonNull(nome, "O nome não pode ser nulo.");
    }

    /**
     * Define o CPF do cliente.
     *
     * @param cpf O CPF do cliente.
     * @throws NullPointerException se o CPF for nulo.
     */
    public void setCpf(String cpf) {
        this.cpf = Objects.requireNonNull(cpf, "O CPF não pode ser nulo.");
    }

    /**
     * Define o e-mail do cliente.
     *
     * @param email O e-mail do cliente.
     * @throws NullPointerException se o e-mail for nulo.
     */
    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "O e-mail não pode ser nulo.");
    }

    /**
     * Define a lista de pedidos do cliente.
     *
     * @param pedidos A lista de pedidos associados ao cliente.
     * @throws NullPointerException se a lista de pedidos for nula.
     */
    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = Objects.requireNonNull(pedidos, "A lista de pedidos não pode ser nula.");
    }

    // O Lombok gera os demais métodos como equals, hashCode e toString.
}
