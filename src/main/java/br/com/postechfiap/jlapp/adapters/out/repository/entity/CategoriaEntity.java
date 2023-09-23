package br.com.postechfiap.jlapp.adapters.out.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "categorias")
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String descricao;

	@OneToMany(mappedBy = "categoriaEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProdutoEntity> produtoEntities = new ArrayList<>();

}
