package br.com.postechfiap.jlapp.infraestrutura.adaptadores.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.postechfiap.jlapp.infraestrutura.adaptadores.entidades.ClienteEntity;

@Repository
public interface SpringClienteRepository extends JpaRepository<ClienteEntity, Long> {

}
