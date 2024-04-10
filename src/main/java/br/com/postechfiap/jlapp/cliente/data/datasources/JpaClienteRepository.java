package br.com.postechfiap.jlapp.cliente.data.datasources;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.cliente.data.models.ClienteModel;

@Repository
public interface JpaClienteRepository extends JpaRepository<ClienteModel, Long> {

	public Optional<ClienteModel> findByCpf(String cpf);

}
