package br.com.postechfiap.jlapp.adapters.out.repository.embedded;

import java.io.Serializable;

import br.com.postechfiap.jlapp.application.core.domain.Pedido;
import br.com.postechfiap.jlapp.application.core.domain.Produto;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
class ItemPedidoEmbeddedId implements Serializable {

	private static final long serialVersionUID = -5309304589509207477L;

	@ManyToOne()
	@JoinColumn(name = "id_pedido_fk", referencedColumnName = "id_pedido", foreignKey = @ForeignKey(name = "id_pedido_fk_esta_para_id_pedido"))
	private Pedido pedido;

	@ManyToOne()
	@JoinColumn(name = "id_produto_fk", referencedColumnName = "id_produto", foreignKey = @ForeignKey(name = "id_produto_fk_esta_para_id_produto"))
	private Produto produto;

}
