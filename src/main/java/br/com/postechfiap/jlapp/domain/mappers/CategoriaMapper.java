package br.com.postechfiap.jlapp.domain.mappers;

import br.com.postechfiap.jlapp.domain.dtos.CategoriaDTO;
import br.com.postechfiap.jlapp.domain.entities.Categoria;

public class CategoriaMapper {

    public static CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(
            categoria.getId(),
            categoria.getNome(),
            categoria.getDescricao()
        );
    }
}
