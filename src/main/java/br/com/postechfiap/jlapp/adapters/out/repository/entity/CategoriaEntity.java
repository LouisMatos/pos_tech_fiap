package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
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
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "categorias")
public class CategoriaEntity implements Serializable {

	private static final long serialVersionUID = 7382732504996930114L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String descricao;

	@OneToMany(mappedBy = "categoriaEntity", cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	private List<ProdutoEntity> produtoEntities;

}
