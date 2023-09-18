package br.com.postechfiap.jlapp.dominio;

import br.com.postechfiap.jlapp.dominio.dto.ClienteDTO;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Cliente {

	private Long id;

	public Cliente(ClienteDTO clienteDTO) {
		this.id = clienteDTO.getId();
	}

}
