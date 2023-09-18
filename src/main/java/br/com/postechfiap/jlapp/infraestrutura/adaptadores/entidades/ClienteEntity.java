package br.com.postechfiap.jlapp.infraestrutura.adaptadores.entidades;

import br.com.postechfiap.jlapp.dominio.Cliente;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class ClienteEntity {

	public ClienteEntity() {

	}

	public ClienteEntity(Cliente cliente) {
		this.id = cliente.getId();
	}

	public void atualizar(Cliente cliente) {
		this.id = cliente.getId();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id2;

	private Long id;
	
}
