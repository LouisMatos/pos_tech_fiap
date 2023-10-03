package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Cliente;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "clientes")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = -6464967453767426458L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Long id;

	private String nome;

	private String cpf;

	private String email;
	
	@OneToMany(mappedBy = "clienteEntity", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<PedidoEntity> pedidosEntities = new ArrayList<PedidoEntity>();

	public ClienteEntity toClienteEntity(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		return this;
	}

}
