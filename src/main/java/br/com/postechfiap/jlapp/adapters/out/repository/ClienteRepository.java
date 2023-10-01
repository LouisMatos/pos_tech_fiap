package br.com.postechfiap.jlapp.adapters.out.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.adapters.out.repository.entity.ClienteEntity;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

	public Optional<ClienteEntity> findByCpf(String cpf);

}
