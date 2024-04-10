package br.com.postechfiap.jlapp.cliente.data.models;

import br.com.postechfiap.jlapp.cliente.domain.entities.Cliente;
import br.com.postechfiap.jlapp.pedido.data.models.PedidoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
public class ClienteModel implements Serializable {

	private static final long serialVersionUID = -6464967453767426458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;
	
	@OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@Column(nullable=true) 
	private List<PedidoModel> pedidoModels;

	private String nome;

	private String cpf;

	private String email;

    public ClienteModel toClienteModel(Cliente cliente) {
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		return this;
    }

	public Cliente toCliente(ClienteModel clienteModel) {
		Cliente cliente = new Cliente();
		cliente.setId(clienteModel.getId());
		cliente.setNome(clienteModel.getNome());
		cliente.setCpf(clienteModel.getCpf());
		cliente.setEmail(clienteModel.getEmail());
		return cliente;
	}
}
