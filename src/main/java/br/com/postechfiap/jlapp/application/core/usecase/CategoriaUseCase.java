package br.com.postechfiap.jlapp.application.core.usecase;

import br.com.postechfiap.jlapp.application.exception.NotFoundException;
import br.com.postechfiap.jlapp.application.ports.in.CategoriaInputPort;
import br.com.postechfiap.jlapp.application.ports.out.CategoriaOutputPort;
import br.com.postechfiap.jlapp.interfaces.dto.CategoriaDTO;
import br.com.postechfiap.jlapp.shared.logger.log.Logger;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoriaUseCase implements CategoriaInputPort {

    private final CategoriaOutputPort categoriaOutputPort;
    private final Logger log;

    @Override
    public CategoriaDTO buscarCategoriaPorId(Long id) {
        log.info("Iniciando busca por categoria com ID: " + id);
        return categoriaOutputPort.buscarCategoriaPorId(id)
                .map(this::convertToCategoriaDTO)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada para o ID: " + id));
    }

    private CategoriaDTO convertToCategoriaDTO(Categoria categoria) {
        // Lógica para converter Categoria em CategoriaDTO
        return new CategoriaDTO().toCategoriaDTO(categoria);
    }
}
