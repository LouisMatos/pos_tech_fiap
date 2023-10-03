package br.com.postechfiap.jlapp.adapters.out.repository.embedded;

import java.io.Serializable;

import br.com.postechfiap.jlapp.application.core.domain.ItemPedido;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Embeddable
@Data
public class SDIPEmbeddedId implements Serializable {

	private static final long serialVersionUID = -5680622526472868500L;

	@ManyToOne()
	private ItemPedido itemPedido;

}