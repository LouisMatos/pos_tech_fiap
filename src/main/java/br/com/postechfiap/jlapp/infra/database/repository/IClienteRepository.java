package br.com.postechfiap.jlapp.infra.database.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infra.database.model.ClienteEntity;

@Repository
public interface IClienteRepository extends JpaRepository<ClienteEntity, Long> {

	public Optional<ClienteEntity> findByCpf(String cpf);

}
