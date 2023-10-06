package br.com.postechfiap.jlapp.infrastructure.adapters.out.repository.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import br.com.postechfiap.jlapp.application.core.domain.Produto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produtos")
public class ProdutoEntity implements Serializable {

	private static final long serialVersionUID = -155386334328457449L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	private String nome;

	private String descricao;

	private BigDecimal preco;

	@ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinColumn(name = "categoria_id")
	private CategoriaEntity categoriaEntity;

	private List<String> imagens;

	public ProdutoEntity toProdutoEntity(Produto produto) {
		this.id = produto.getId();
		this.categoriaEntity = new CategoriaEntity().toCategoriaEntity(produto.getCategoria());
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.preco = produto.getPreco();
		this.imagens = produto.getImagens();
		this.categoriaEntity = categoriaEntity.toCategoriaEntity(produto.getCategoria());
		return this;
	}
}
